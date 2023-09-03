package core;

public class Helpers {
	
	public String message(String msg, String type) {
			
		String message = "";
		
		if(type.equals("error")) {
			message = "<div class=\"py-2\">\r\n"
					+ "	<div class=\"row\">\r\n"
					+ "		<div class=\"col-md-12\">\r\n"
					+ "			<div class=\"alert alert-danger text-center\" role=\"alert\">\r\n"
					+ "			<strong>"+ msg +"</strong></div>\r\n"
					+ "		</div>\r\n"
					+ "	</div>\r\n"
					+ "</div>";
		}
		
		if(type.equals("success")) {
			message = "<div class=\"py-2\">\r\n"
					+ "	<div class=\"row\">\r\n"
					+ "		<div class=\"col-md-12\">\r\n"
					+ "			<div class=\"alert alert-success text-center\" role=\"alert\">\r\n"
					+ "			<strong>"+ msg +"</strong></div>\r\n"
					+ "		</div>\r\n"
					+ "	</div>\r\n"
					+ "</div>";
		}
		
		return message;
	}

}
