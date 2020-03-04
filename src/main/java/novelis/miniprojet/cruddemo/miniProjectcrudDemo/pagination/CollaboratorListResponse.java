package novelis.miniprojet.cruddemo.miniProjectcrudDemo.pagination;


import java.util.Collection;

import novelis.miniprojet.cruddemo.miniProjectcrudDemo.dto.CollaboratorDto;

public class CollaboratorListResponse extends SuccessResponse {
	
	private final PageMeta pageMeta;
    private final Collection<CollaboratorDto> collaborator;

    public CollaboratorListResponse(PageMeta pageMeta, Collection<CollaboratorDto> collaborator) {
        this.collaborator = collaborator;
        this.pageMeta = pageMeta;
    }

    public PageMeta getPageMeta() {
        return pageMeta;
    }

    public Collection<CollaboratorDto> getCollaborator() {
        return collaborator;
    }

}
