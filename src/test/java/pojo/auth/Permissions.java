package pojo.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Permissions {
    @JsonProperty("import")
    public boolean myImport;
    public boolean flow_assets;
    public boolean common_collections;
    public boolean common_and_public_collections;
    public boolean assets_links_view;
    public boolean assets_links_edit;
    public boolean can_view_comments;
}
