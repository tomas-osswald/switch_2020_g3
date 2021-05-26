package switchtwentytwenty.project.dto.category;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputCategoryTreeDTOTest {

    @Test
    void testEquals() {
        OutputCategoryDTO output1 = new OutputCategoryDTO("name", "2", "1", "@family@id.com");
        OutputCategoryDTO output2 = new OutputCategoryDTO("name2", "3", "4", "@family@id.com");
        List<OutputCategoryDTO> outputDtoList = new ArrayList<>();
        outputDtoList.add(output1);
        outputDtoList.add(output2);

        OutputCategoryTreeDTO outputCategoryTreeDTO1 = new OutputCategoryTreeDTO(outputDtoList);
        OutputCategoryTreeDTO outputCategoryTreeDTO2 = new OutputCategoryTreeDTO(outputDtoList);

        assertEquals(outputCategoryTreeDTO1, outputCategoryTreeDTO2);

    }

    @Test
    void testEqualsSameObject() {
        OutputCategoryDTO output1 = new OutputCategoryDTO("name", "2", "1", "@family@id.com");
        OutputCategoryDTO output2 = new OutputCategoryDTO("name2", "3", "4", "@family@id.com");
        List<OutputCategoryDTO> outputDtoList = new ArrayList<>();
        outputDtoList.add(output1);
        outputDtoList.add(output2);

        OutputCategoryTreeDTO outputCategoryTreeDTO1 = new OutputCategoryTreeDTO(outputDtoList);
        OutputCategoryTreeDTO outputCategoryTreeDTO2 = new OutputCategoryTreeDTO(outputDtoList);

        assertEquals(outputCategoryTreeDTO1, outputCategoryTreeDTO1);

    }

    @Test
    void testEqualsDifferentType() {
        OutputCategoryDTO output1 = new OutputCategoryDTO("name", "2", "1", "@family@id.com");
        OutputCategoryDTO output2 = new OutputCategoryDTO("name2", "3", "4", "@family@id.com");
        List<OutputCategoryDTO> outputDtoList = new ArrayList<>();
        outputDtoList.add(output1);
        outputDtoList.add(output2);

        OutputCategoryTreeDTO outputCategoryTreeDTO1 = new OutputCategoryTreeDTO(outputDtoList);
        String notSameObject = "string";
        assertFalse(outputCategoryTreeDTO1.equals(notSameObject));

    }

    @Test
    void testHashCode() {
        OutputCategoryDTO output1 = new OutputCategoryDTO("name", "2", "1", "@family@id.com");
        OutputCategoryDTO output2 = new OutputCategoryDTO("name2", "3", "4", "@family@id.com");
        List<OutputCategoryDTO> outputDtoList = new ArrayList<>();
        outputDtoList.add(output1);
        outputDtoList.add(output2);

        OutputCategoryTreeDTO outputCategoryTreeDTO1 = new OutputCategoryTreeDTO(outputDtoList);
        OutputCategoryTreeDTO outputCategoryTreeDTO2 = new OutputCategoryTreeDTO(outputDtoList);

        assertEquals(outputCategoryTreeDTO1.hashCode(), outputCategoryTreeDTO2.hashCode());
        assertNotEquals(0, outputCategoryTreeDTO1.hashCode());
        assertNotEquals(0, outputCategoryTreeDTO2.hashCode());
    }

    @Test
    void addOutputCategoryDTO() {
        OutputCategoryDTO output1 = new OutputCategoryDTO("name", "2", "1", "@family@id.com");
        OutputCategoryTreeDTO outputCategoryTreeDTO1 = new OutputCategoryTreeDTO();
        assertNotNull(outputCategoryTreeDTO1);
        int hash1 = outputCategoryTreeDTO1.hashCode();
        outputCategoryTreeDTO1.addOutputCategoryDTO(output1);
        int hash2 = outputCategoryTreeDTO1.hashCode();

        assertNotEquals(hash1, hash2);
    }

    @Test
    void setOutputCategoryDTOList() {
        OutputCategoryDTO output1 = new OutputCategoryDTO("name", "2", "1", "@family@id.com");
        OutputCategoryDTO output2 = new OutputCategoryDTO("name2", "3", "4", "@family@id.com");
        List<OutputCategoryDTO> outputDtoList = new ArrayList<>();
        outputDtoList.add(output1);
        outputDtoList.add(output2);

        OutputCategoryTreeDTO outputCategoryTreeDTO1 = new OutputCategoryTreeDTO();

        outputCategoryTreeDTO1.setOutputCategoryDTOList(outputDtoList);

        List<OutputCategoryDTO> result = outputCategoryTreeDTO1.getOutputCategoryDTOList();

        assertEquals(outputDtoList, result);
    }
}

