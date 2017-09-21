package action;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import form.TestUploadFileForm;

public class TestUploadFileAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		TestUploadFileForm uploadForm = (TestUploadFileForm) form;
		FileOutputStream outputStream = null;
		FormFile file = null;

		// start getting File
		try {
			file = uploadForm.getFile();

			// getRealPath("") does not work properly
			// ==> use direct path like "E:\Workspace\WorkspaceEclipse\...\images\\users" + fileName
			String path = getServlet().getServletContext().getRealPath("") + "/" + file.getFileName();

			System.out.println("Path: " + path);

			outputStream = new FileOutputStream(new File(path));
			outputStream.write(file.getFileData());
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
		return mapping.findForward("dung");
	}

}
