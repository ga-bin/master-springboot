package com.in28minutes.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter("SomeBeanFilter") // controller에서 dynamic filter를 사용하기 위해 설정한다.
//@JsonIgnoreProperties({"field1", "field2"}) // class레벨이서도 jsonIgnore를 설정할 수 있다.
public class SomeBean {
	private String field1;
	
	// @JsonIgnore // json으로 반환될 떄 해당 필드는 반환되지 않도록 해준다
	private String field2;
	
	private String field3;
	
	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

	@Override
	public String toString() {
		return "SomeBean [field1=" + field1 + ", field2=" + field2 + ", field3=" + field3 + "]";
	}
	
}
