package com.iiht.forum.dto;

public class PostExceptionResponse extends RuntimeException {

	private static final long serialVersionUID = -2808402564232074577L;

	private String message;
	private long timeStamp;
	private int status;

	public PostExceptionResponse(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PostExceptionResponse(String message, long timeStamp, int status) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
		this.status = status;
	}
	
	public PostExceptionResponse() {
		super();
	}

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimeStamp() {
        return timeStamp;
    }
    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
}