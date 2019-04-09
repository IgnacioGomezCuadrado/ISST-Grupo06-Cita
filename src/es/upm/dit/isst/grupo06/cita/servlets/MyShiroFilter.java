package es.upm.dit.isst.grupo06.cita.servlets;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import org.apache.shiro.web.servlet.ShiroFilter;

@WebFilter(initParams = { @WebInitParam(name = "configPath", value = "classpath:shiro.ini") }, urlPatterns = {"/*"})
public class MyShiroFilter extends ShiroFilter {
}