package com.epuz.web.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageMaker {
	
	private int totalCount;
	private int startPage;
	private int endPage;
	private boolean prev;
	private boolean next;
	
	private int displayPageNum = 10;
	
	private PageSet pageSet;
	
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		
		calcData();
	}
	
	private void calcData() {
		endPage = (int) (Math.ceil(pageSet.getPage() / (double) displayPageNum) * displayPageNum);
		
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) pageSet.getPerPageNum()));
		
		if(endPage > tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage == 1 ? false : true;
		
		next = endPage * pageSet.getPerPageNum() >= totalCount ? false : true;
	}

}
