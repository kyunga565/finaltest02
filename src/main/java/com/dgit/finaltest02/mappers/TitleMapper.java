package com.dgit.finaltest02.mappers;

import java.util.List;
import com.dgit.finaltest02.dto.Title;


public interface TitleMapper {
	List<Title> selectAll(); 
	Title selectTitle(int no);
	int getTno();
	void insertTitle(Title dObj);
	void updateTitle(Title dObj);
	void deleteTitle(String no);
}
