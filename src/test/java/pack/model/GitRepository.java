package pack.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitRepository {
	@JsonAlias("id")
	private long id;

	@JsonAlias("node_id")
	private String nodeId;

	@JsonAlias("name")
	private String name;

	@JsonAlias("full_name")
	private String fullName;

	@JsonAlias("html_url")
	private String htmlUrl;

	@JsonAlias("description")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getHtmlUrl() {
		return htmlUrl;
	}

	public void setHtmlUrl(String htmlUrl) {
		this.htmlUrl = htmlUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "\nGitRepository [id=" + id + ",\nnodeId=" + nodeId + ",\nname=" + name + ",\nfullName=" + fullName
				+ ",\nhtmlUrl=" + htmlUrl + ",\ndescription=" + description + "]";
	}
}
