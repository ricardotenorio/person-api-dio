package ricardotenorio.github.com.personapi.utils;

import ricardotenorio.github.com.personapi.dto.request.PhoneDTO;
import ricardotenorio.github.com.personapi.entity.Phone;
import ricardotenorio.github.com.personapi.enums.PhoneType;

public class PhoneUtils {

  private static final String PHONE_NUMBER = "1111111-1111";
  private static final PhoneType PHONE_TYPE= PhoneType.MOBILE;
  private static final long PHONE_ID = 1L;

  public static PhoneDTO createFakeDTO() {
    return PhoneDTO.builder()
            .number(PHONE_NUMBER)
            .type(PHONE_TYPE)
            .build();
  }

  public static Phone createFakeEntity() {
    return Phone.builder()
            .id(PHONE_ID)
            .number(PHONE_NUMBER)
            .type(PHONE_TYPE)
            .build();
  }
}
