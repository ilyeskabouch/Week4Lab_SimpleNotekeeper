package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author ilyes
 */
public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String edit = request.getParameter("edit");

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));
            Note note = new Note(br.readLine(),br.readLine());
            request.setAttribute("note", note);
            br.close();
        } catch (IOException e) {

        }

        if (edit == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                    .forward(request, response);
        } else {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Note note = new Note(request.getParameter("title"), request.getParameter("content"));

        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        try {
            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
            pw.println(note.getTitle());
            pw.println(note.getContent());
            pw.close();
        } catch (IOException e) {

        }

        request.setAttribute("note", note);

        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
    }
}
