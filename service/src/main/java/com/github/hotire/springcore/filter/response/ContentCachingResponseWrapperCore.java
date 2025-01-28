package com.github.hotire.springcore.filter.response;


import java.io.IOException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.ServletResponseWrapper;
import jakarta.servlet.WriteListener;
import lombok.RequiredArgsConstructor;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.util.ContentCachingResponseWrapper;

/**
 * @see ContentCachingResponseWrapper
 */
public class ContentCachingResponseWrapperCore {

    /**
     * @see ContentCachingResponseWrapper#content
     */
    private final FastByteArrayOutputStream content = new FastByteArrayOutputStream(1024);

    /**
     * @see ContentCachingResponseWrapper#outputStream
     */
    private ServletOutputStream outputStream;

    /**
     * @see ServletResponseWrapper#response
     */
    private ServletResponse response;


    /**
     * @see ContentCachingResponseWrapper#getOutputStream()
     */
    public ServletOutputStream getOutputStream() throws IOException {
        if (this.outputStream == null) {
            this.outputStream = new ContentCachingResponseWrapperCore.ResponseServletOutputStream(getResponse().getOutputStream());
        }
        return this.outputStream;
    }

    public ServletResponse getResponse() {
        return this.response;
    }


    /**
     * @see ContentCachingResponseWrapper.ResponseServletOutputStream
     */
    @RequiredArgsConstructor
    private class ResponseServletOutputStream extends ServletOutputStream {

        private final ServletOutputStream os;

        @Override
        public boolean isReady() {
            return false;
        }

        @Override
        public void setWriteListener(WriteListener listener) {

        }

        @Override
        public void write(int b) throws IOException {

        }
    }
}
