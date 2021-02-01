package edu.bit.ex.paging;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class PageVO {
	private int displayPageNum = 10;
	private int startPage;
	private int endPage;
	private boolean prev,next;
	
	private Criteria cri;
	private int total;
	
	public PageVO(Criteria cri, int total) {
		this.cri = cri;
		this.total = total;
		
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * displayPageNum;
		this.startPage = (this.endPage - displayPageNum) + 1;
		
		int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));
		
		if(realEnd <= this.endPage) {
			this.endPage = realEnd;
			
			this.prev = this.startPage > 1;
			this.next = this.endPage < realEnd;
		}
	}
	
	public String makeQuery(int page) {
		UriComponents uriBuilder = UriComponentsBuilder.newInstance().queryParam("pageNum", page)
		.queryParam("amount", cri.getAmount())
		.build();
		
		return uriBuilder.toUriString();
	}
}
