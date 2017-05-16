/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proj.logic;

/**
 *
 * @author alecdivito
 */
public class InvalidString extends Exception{
    
    public InvalidString() { super(); }
    public InvalidString(String message) { super(message); }
    public InvalidString(String message, Throwable cause) { super(message, cause); }
    public InvalidString(Throwable cause) { super(cause); }
    
}
