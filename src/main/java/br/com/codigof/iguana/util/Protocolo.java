/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.codigof.iguana.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Thiago Aderaldo Lessa
 */
@ManagedBean(name="protocoloController")
public class Protocolo {

    public String createProtocolo() {

        //Você pode alterar o valor de 'yyyy-MM-dd HH:mm:ss'
        //para 'dd/MM/yyyy HH:mm:ss', por exemplo. 
        String hora = "yyyyMMddHHmmss";
        SimpleDateFormat df = new SimpleDateFormat(hora);
        df.setTimeZone(TimeZone.getTimeZone("Brazil/East"));
        String protocolo = df.format(new Date());
        
        return protocolo;
    }
}
