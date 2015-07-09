package com.temenos.t24.tools.eclipse.basic.protocols;

/**
 * Object used to transmit responses from "protocol layer" up-stream.
 * The protocol layer has been designed to send/receive XML messages
 * (or Commands) over HTTP to Browser.
 */
public class Response {
    // Main response data (could be a file, another object, etc)
    private Object objectData = null;

    // textual message adding some additional explanation to the response.
    private String respMessage = "DEFAULT MESSAGE";

    // The response might include a code with some pre-defined meaning.    
    private String respCode = "-1"; // Default value is -1

    // true/false; provides a quick boolean way of establishing whether the 
    // action passed or fail. 
    // Note: if passed = false then it is expected by the client to find an explanation of the failure
    // in the respMessage variable.
    private boolean passed = false;

    // Each roundtrip to server has a session token.
    // Session tokens are generated by the server.
    private String sessionToken = "";
    
    // time it takes to execute an action whose response is this one
    private long actionTimeMillis = 0;
    
    public Response(){        
    }
    
    public Response(Response res){
        objectData          = res.getObject();
        respMessage   = res.getRespMessage();
        respCode      = res.getRespCode();
        passed        = res.getPassed();
        sessionToken  = res.getSessionToken();
    }
    
    public void setObject(Object resp){
        this.objectData = resp;
    }
    public void setRespMessage(String respMessage){
        this.respMessage = respMessage;
    }
    public void setMessage(String respMessage){
        this.respMessage = respMessage;
    }    
    public void setRespCode(String respCode){
        this.respCode = respCode;
    }
    public void setPassed(boolean passed){
        this.passed = passed;
    }
    public void setSessionToken(String sessionToken){
        this.sessionToken = sessionToken;
    }
    public void setActionTimeMillis(Long actionTimeMillis){
        this.actionTimeMillis = actionTimeMillis;
    }    
    public Object getObject(){
        return this.objectData;
    }
    public String getRespMessage(){
        return this.respMessage;
    }
    public String getRespCode(){
        return this.respCode;
    }
    public boolean getPassed(){
        return this.passed;
    }
    public String getSessionToken(){
        return this.sessionToken;
    }
    public Long getActionTimeMillis(){
        return this.actionTimeMillis;
    }
    public String toString(){
        return "Passed: "+passed+" Token: "+sessionToken+" Object: "+(String)objectData;
    }
}
