/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;


public class Message implements Serializable {
 private TrackList model;
 private String str;
 
 public Message(){
     this.model=null;
     this.str=null;
 }
 public Message(TrackList model, String str){
     this.model=model;
     this.str=str;
 }
 public void setModel(TrackList model){
     this.model=model;
 }
 public void setStr(String str){
     this.str=str;
 }
 public String getStr(){
     return this.str;
 }
 public TrackList getModel(){
     return this.model;
 }
}
