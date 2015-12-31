package ee.erp.central.user.components;

import com.vaadin.server.Page;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload;

import java.io.*;

/**
 * Created by Artyom on 12/29/2015.
 */
public class FileUploader implements Upload.Receiver, Upload.SucceededListener, Upload.FailedListener, Upload.StartedListener {

    private Upload upload;

    public Upload init() {
        upload = new Upload("Upload", this);
        upload.setButtonCaption("upl");
        upload.addFailedListener(this);
        upload.addSucceededListener(this);
        upload.addStartedListener(this);
        upload.setReceiver(this);
        return upload;
    }

    @Override
    public OutputStream receiveUpload(String fileName, String mimeType) {

        try {
            return new OutputStream() {
                @Override
                public void write(int b) throws IOException {
                    System.out.printf(String.valueOf((char)b));
                }
            };
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void uploadSucceeded(Upload.SucceededEvent succeededEvent) {
        System.out.printf("done");
        //new Notification("File Uploaded", Notification.Type.HUMANIZED_MESSAGE).show(Page.getCurrent());
    }

    @Override
    public void uploadFailed(Upload.FailedEvent failedEvent) {
        System.out.printf("failed");
        //new Notification("File Upload Failed", Notification.Type.HUMANIZED_MESSAGE).show(Page.getCurrent());
    }

    @Override
    public void uploadStarted(Upload.StartedEvent startedEvent) {
        System.out.printf("started");
        //new Notification("File Upload Started", Notification.Type.HUMANIZED_MESSAGE).show(Page.getCurrent());
    }
}
