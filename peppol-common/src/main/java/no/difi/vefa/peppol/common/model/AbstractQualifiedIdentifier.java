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

package no.difi.vefa.peppol.common.model;

import no.difi.vefa.peppol.common.api.QualifiedIdentifier;
import no.difi.vefa.peppol.common.util.ModelUtils;

/**
 * @author erlend
 */
public abstract class AbstractQualifiedIdentifier implements QualifiedIdentifier {

    protected final Scheme scheme;

    protected final String identifier;

    public AbstractQualifiedIdentifier(String identifier, Scheme scheme) {
        this.identifier = identifier == null ? null : identifier.trim();
        this.scheme = scheme;
    }

    @Override
    public Scheme getScheme() {
        return scheme;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String urlencoded() {
        return ModelUtils.urlencode("%s::%s", scheme.getIdentifier(), identifier);
    }
}
