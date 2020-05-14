package org.codigolimpo.IBGE.service;

public class IBGEURLs {
    private static final String SEPARATOR = String.valueOf('/');
    private static final String URL_BASE = "https://servicodados.ibge.gov.br/api/v1/localidades";
    static final String STATES = "estados";
    static final String MUNICIPALITIES = "municipios";

    String produceRESTURL(String objectName, int id) {
        return String.join(SEPARATOR, produceRESTURL(objectName), String.valueOf(id));
    }

    String produceRESTURL(String objectName) {
        return String.join(SEPARATOR, URL_BASE, objectName);
    }

    String produceRESTURL(String objectNameOutside, int id, String objectNameInside) {
        final String baseURL = produceRESTURL(objectNameOutside, id);
        return String.join(SEPARATOR, baseURL, objectNameInside);
    }

}
