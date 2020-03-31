/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author demonslight
 */

import java.io.File;

public class Resource {
    public static final String RESOURCE_LOCATION = "res/layout"; // root
    public static File getResourceFileStream(String name) {
        return new File(RESOURCE_LOCATION + "/" + name + ".xml");
    }
}
