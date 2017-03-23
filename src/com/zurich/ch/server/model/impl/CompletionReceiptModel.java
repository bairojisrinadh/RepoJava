/**
 * Project:    eDec
 * Filename:   CompletionReceiptModel.java
 * Copyright:  CSC Switzerland
 * Created on: Sep 26, 2007, 12:12:55 PM
 */
package com.zurich.ch.server.model.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import org.hibernate.Hibernate;

import com.zurich.ch.server.model.AbstractModel;

/**
 * CompletionReceiptModel
 * @author pdixit
 * Class description goes here.....
 */
public class CompletionReceiptModel extends AbstractModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer lohnmeldung_id;
	private Blob pdf;
	private byte[] bis;

	public Integer getLohnmeldung_id() {
		return lohnmeldung_id;
	}

	public void setLohnmeldung_id(Integer lohnmeldung_id) {
		this.lohnmeldung_id = lohnmeldung_id;
	}

	public Blob getPdf() {
		return Hibernate.createBlob(this.bis);
	}

	public void setPdf(Blob pdf) {
		this.bis = toByteArray(pdf);
	}

	public byte[] getBis() {
		return bis;
	}

	public void setBis(byte[] bis) {
		this.bis = bis;
	}

	private byte[] toByteArray(Blob fromImageBlob) {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			return toByteArrayImpl(fromImageBlob, baos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private byte[] toByteArrayImpl(Blob fromImageBlob,
			ByteArrayOutputStream baos) throws SQLException, IOException {
		byte buf[] = new byte[4000];
		int dataSize;
		InputStream is = fromImageBlob.getBinaryStream();

		try {
			while ((dataSize = is.read(buf)) != -1) {
				baos.write(buf, 0, dataSize);
			}
		} finally {
			if (is != null) {
				is.close();
			}
		}
		return baos.toByteArray();
	}

}
