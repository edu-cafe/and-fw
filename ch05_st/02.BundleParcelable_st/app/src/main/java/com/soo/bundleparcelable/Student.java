package com.soo.bundleparcelable;

import android.R.string;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class Student implements ......... {
	
	public String name;
	public int age;
	public String birthday;

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(Parcel in) {
		readFromParcel(in);
		Log.d("SOO", "Student(Parcel) =====> name:" + name + ", age:" + age + ", birthday:" + birthday);
	}
	
	public Student(String name, int age, String birthday) {
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		
		Log.d("SOO", "Student(n,a,b) ==> name:" + name + ", age:" + age + ", birthday:" + birthday);
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void .......... (Parcel dest, int flags) {
		Log.d("SOO", "----->writeToParcel()");
		dest.writeString(name);
		dest.writeInt(age);
		dest.writeString(birthday);
	}
	
	public void ......... (Parcel in) {
		Log.d("SOO", "----->readFromParcel()");
		name = in.readString();
		age = in.readInt();
		birthday = in.readString();
	}
	
	public static final Creator<Student> .......  = new Creator<.....>() {

		@Override
		public Student ......... (Parcel source) {
			Log.d("SOO", "----->CREATOR:createFromParcel()");
			return new ......... (source);
		}

		@Override
		public Student[] newArray(int size) {
			Log.d("SOO", "----->CREATOR:newArray()");
			return new Student[size];
		}
	};
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getBirtday() {
		return birthday;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setBirtday(String birthday) {
		this.birthday = birthday;
	}
	
}
