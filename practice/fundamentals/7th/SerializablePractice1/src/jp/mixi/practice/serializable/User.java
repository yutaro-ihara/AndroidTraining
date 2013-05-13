package jp.mixi.practice.serializable;

import java.util.Date;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable{
    private String name;
    private int id;
    private int age;
    private String keyword;
    private Status status;
    private int mData;
    
    public User() {
	}
    
    private User(Parcel in) {
    	mData = in.readInt();
    }
    
    public void setData(int data) {
    	mData = data;
    }
    
    public int getData() {
    	return mData;
    }
    
    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public static class Status{
        private Date postedDate;
        private String text;
        public Date getPostedDate() {
            return postedDate;
        }
        public String getText(){
            return text;
        }
        public void setPostedDate(Date date){
            this.postedDate = date;
        }
        public void setText(String text) {
            this.text = text;
        }
    }

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeInt(mData);
	}
	
	public static final Parcelable.Creator<User> CREATER = new Parcelable.Creator<User>() {

		@Override
		public User createFromParcel(Parcel source) {
			return new User(source);
		}

		@Override
		public User[] newArray(int size) {
			return new User[size];
		}
		
	};

}
