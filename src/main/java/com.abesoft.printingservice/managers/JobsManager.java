package com.abesoft.printingservice.managers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope(value = "session")
public class JobsManager {

 public String test() {
  return "helow world !";
 }
}