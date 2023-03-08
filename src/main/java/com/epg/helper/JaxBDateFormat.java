package com.epg.helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import org.springframework.stereotype.Component;

@Component
public class JaxBDateFormat extends XmlAdapter<String, Date> {

	private final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

	@Override
	public Date unmarshal(String string) throws Exception {
		// TODO Auto-generated method stub
		return dateFormat.parse(string);
	}

	@Override
	public String marshal(Date date) throws Exception {
		// TODO Auto-generated method stub
		return dateFormat.format(date);
	}

}
