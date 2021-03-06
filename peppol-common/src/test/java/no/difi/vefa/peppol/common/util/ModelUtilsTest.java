/*
 * Copyright 2015-2017 Direktoratet for forvaltning og IKT
 *
 * This source code is subject to dual licensing:
 *
 *
 * Licensed under the EUPL, Version 1.1 or – as soon they
 * will be approved by the European Commission - subsequent
 * versions of the EUPL (the "Licence");
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 *
 * See the Licence for the specific language governing
 * permissions and limitations under the Licence.
 */

package no.difi.vefa.peppol.common.util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ModelUtilsTest {

    @Test
    public void simpleConstructor() {
        new ModelUtils();
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void simpleEncoderNullPointer() {
        ModelUtils.urlencode(null, "Some", "values");
    }

    @Test(expectedExceptions = IllegalStateException.class)
    public void simpleDecoderNullPointer() {
        ModelUtils.urldecode(null);
    }

    @Test
    public void simple() throws Exception {
        String value = "9908:991825827";

        String encoded = ModelUtils.urlencode(value);
        Assert.assertNotEquals(encoded, value);

        String decoded = ModelUtils.urldecode(encoded);
        Assert.assertEquals(decoded, value);
    }
}
