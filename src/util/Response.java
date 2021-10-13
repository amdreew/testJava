package util;

public class Response<T> {
	
	private T data;
    private Notification notification;    
    
    
	public Response() {
	}


	public T getData() {
		return data;
	}


	public void setData(T data) {
		this.data = data;
	}


	public Notification getNotification() {
		return notification;
	}


	public void setNotification(Notification notification) {
		this.notification = notification;
	}    
    
}
