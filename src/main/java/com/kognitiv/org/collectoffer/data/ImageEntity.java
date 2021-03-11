package com.kognitiv.org.collectoffer.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Image")
public class ImageEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9095688368025612539L;

	@Id
	@GeneratedValue
	private long internalId;

	@Column(nullable = false, unique = true)
	private long albumId;

	@Column(nullable = false, unique = true)
	private long id;

	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false, length = 400)
	private String url;

	@Column(nullable = false, length = 400)
	private String thumbnailUrl;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getAlbumId() {
		return albumId;
	}

	public void setAlbumId(long albumId) {
		this.albumId = albumId;
	}

	public long getInternalId() {
		return internalId;
	}

	public void setInternalId(long internalId) {
		this.internalId = internalId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getThumbnailUrl() {
		return thumbnailUrl;
	}

	public void setThumbnailUrl(String thumbnailUrl) {
		this.thumbnailUrl = thumbnailUrl;
	}

}
