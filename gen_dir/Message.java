package com.mountain.po;

public class Message {

    private Long id;
    private String nickName;
    private String ip;
    private Date insertName;

    public Long getId(){
      return id;
    }
    public void setId(Long id){
      this.id = id;
    }
    public String getNickName(){
      return nickName;
    }
    public void setNickName(String nickName){
      this.nickName = nickName;
    }
    public String getIp(){
      return ip;
    }
    public void setIp(String ip){
      this.ip = ip;
    }
    public Date getInsertName(){
      return insertName;
    }
    public void setInsertName(Date insertName){
      this.insertName = insertName;
    }

}