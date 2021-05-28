package switchtwentytwenty.project.usecaseservices.applicationservices.implappservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import switchtwentytwenty.project.domain.aggregates.family.Family;
import switchtwentytwenty.project.domain.valueobject.FamilyID;
import switchtwentytwenty.project.dto.assemblers.implassemblers.FamilyDTODomainAssembler;
import switchtwentytwenty.project.dto.family.FamilyMemberAndRelationsListDTO;
import switchtwentytwenty.project.usecaseservices.applicationservices.iappservices.IGetFamilyMembersAndRelationshipService;
import switchtwentytwenty.project.usecaseservices.irepositories.IFamilyRepository;

@Service
public class GetFamilyMembersAndRelationshipService implements IGetFamilyMembersAndRelationshipService {

    FamilyDTODomainAssembler familyDTODomainAssembler = new FamilyDTODomainAssembler();

    IFamilyRepository familyRepository;

    @Autowired
    public GetFamilyMembersAndRelationshipService(IFamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    @Override
    public FamilyMemberAndRelationsListDTO getFamilyMembersAndRelations(String familyID) {
        FamilyID internalFamilyID = familyDTODomainAssembler.familyIDToDomain(familyID);
        Family family = familyRepository.getByID(internalFamilyID);

return null;
    }
}
