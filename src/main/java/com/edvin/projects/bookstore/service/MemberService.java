package com.edvin.projects.bookstore.service;

import com.edvin.projects.bookstore.entity.Member;

public interface MemberService {
	
	public Member createMember(Member member);
	
	public Member updateMember(Member member);
	
	public Member getMemberById(Integer memberId);
	
	public Member deleteMember(Integer memberId);
	
	public Member getMemberByEmail(String email);
	
	public Member getMemberByPhoneNumber(String phoneNumber);
	
	public Member getMemberByLastName(String lastName);
	
	

}
