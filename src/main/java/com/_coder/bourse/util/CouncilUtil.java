package com._coder.bourse.util;

import com._coder.bourse.dto.CouncilDto;
import com._coder.bourse.model.Council;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@NoArgsConstructor
public class CouncilUtil {

    public  static CouncilDto councilUtilDto(
            String councilName,
            String country,
            String mayorName,
            String email,
            String region, MultipartFile councilImage)  {


           return CouncilDto
                    .builder()
                    .councilName(councilName)
                    .country(country)
                    .mayorName(mayorName)
                    .email(email)
                    .region(region)
                    .imageCouncil(councilImage)
                    .build();

    }
    public static Council councilUtil(CouncilDto dto, MultipartFile councilImage) throws IOException {
        String imagePath0 = ImageUtil.saveImage(councilImage,"council-image" );

        return Council
                .builder()
                .councilName(dto.getCouncilName())
                .country(dto.getCountry())
                .email(dto.getEmail())
                .mayorName(dto.getMayorName())
                .region(dto.getRegion())
                .ImagePath(imagePath0)
                .build();
    }

}
