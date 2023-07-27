package com.ipartek.formacion.amazonia.listeners;

import com.ipartek.formacion.amazonia.modelos.Cesta;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SesionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se)  { 
    	se.getSession().setAttribute("cesta", new Cesta());
    }
}
