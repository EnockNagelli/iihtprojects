package com.iiht.forum.dto;

public class CommentExceptionResponse extends RuntimeException 
{
	private static final long serialVersionUID = 440057023862666157L;

	private String message;
	private long timeStamp;
	private int status;
	
	public CommentExceptionResponse() {
		super();
	}

	public CommentExceptionResponse(String message, long timeStamp, int status) {
		super();
		this.message = message;
		this.timeStamp = timeStamp;
		this.status = status;
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