package vn.iostar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@WebServlet("/displayImage")
public class DisplayImgController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 String imageName = request.getParameter("imageName");
         if (imageName == null || imageName.isEmpty()) {
             response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Image name is missing.");
             return;
         }

         // Get the path to the images directory
         String imageDirPath = getServletContext().getRealPath("/images");
         File imageFile = new File(imageDirPath, imageName);
         
         if (imageFile.exists()) {
             response.setContentType("image/jpeg"); // Adjust based on the image type
             response.setContentLength((int) imageFile.length());

             try (FileInputStream fileInputStream = new FileInputStream(imageFile);
                  OutputStream outputStream = response.getOutputStream()) {
                 byte[] buffer = new byte[1024];
                 int bytesRead;
                 while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                     outputStream.write(buffer, 0, bytesRead);
                 }
             }
         } else {
             response.sendError(HttpServletResponse.SC_NOT_FOUND, "Image not found.");
         }
    }
}
