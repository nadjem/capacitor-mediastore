package com.agorapulse.capacitor.mediastore;

import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.annotation.CapacitorPlugin;
import com.getcapacitor.annotation.PluginMethod;

@CapacitorPlugin(name = "MediaStore")
public class MediaStorePlugin extends Plugin {

    private final Mediastore implementation = new Mediastore();

    @PluginMethod
    public void saveImage(PluginCall call) {
        String filename = call.getString("filename");
        if (filename == null) {
            call.reject("filename is required");
            return;
        }
        String content = call.getObject("content").getString("data");
        if (content == null) {
            call.reject("content is required");
            return;
        }

        try {
            String uri = implementation.saveImage(getContext(), filename, content);
            call.resolve();
        } catch (Exception e) {
            call.reject("Save failed", e);
        }
    }

    @PluginMethod
    public void saveDocument(PluginCall call) {
        String filename = call.getString("filename");
        if (filename == null) {
            call.reject("filename is required");
            return;
        }
        String content = call.getObject("content").getString("data");
        if (content == null) {
            call.reject("content is required");
            return;
        }
        String mimeType = call.getString("mimeType", "application/octet-stream");

        try {
            String uri = implementation.saveDocument(getContext(), filename, mimeType, content);
            call.resolve();
        } catch (Exception e) {
            call.reject("Save failed", e);
        }
    }
}
