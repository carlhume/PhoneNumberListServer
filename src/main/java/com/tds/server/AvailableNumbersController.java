package com.tds.server;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailableNumbersController {

    @CrossOrigin(origins = "*")
    @GetMapping("/localeData")
    public ResponseEntity<LocaleData[]> getLocaleData() {
/*
        Geometry ottawaLocation = new Geometry( "Feature", new double[] { 45.4215, -75.6972 } );
        LocaleData ottawa = new LocaleData( 960, "Ottawa", 321, ottawaLocation );

        Geometry kingstonLocation = new Geometry( "Feature", new double[] { 44.2312, -76.4860 } );
        LocaleData kingston = new LocaleData( 1229, "Kingston", 175, kingstonLocation );

        LocaleData [] dataToReturn = new LocaleData[] { ottawa, kingston };

 */
        LocaleService service = new LocaleService();
        LocaleData [] dataToReturn = service.getTop20LocalesWithNumbersToCall();
        return ResponseEntity.ok( dataToReturn );

    }

}
