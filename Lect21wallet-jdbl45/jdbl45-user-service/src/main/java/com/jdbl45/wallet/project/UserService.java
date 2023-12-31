package com.jdbl45.wallet.project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private static final String USER_CREATE = "user_create_topic";

	@Autowired
	UserRepo userRepository;

	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;

	@Autowired
	ObjectMapper mapper;

	public User create(User user) throws JsonProcessingException {
		user = userRepository.save(user);

		// TODO: Add code for wallet addition
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("userId", user.getId());
		jsonObject.put("userEmail", user.getEmail());
		jsonObject.put("userContact", user.getContact());

		kafkaTemplate.send(USER_CREATE, jsonObject.toJSONString());

		return user;
	}

	public User get(int id) {

		return userRepository.findById(id).orElse(null);
	}
}