/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swp.servlets.ens;

import com.swp.beans.Enseignant;
import com.swp.beans.Filiere;
import com.swp.beans.Message;
import com.swp.beans.Seance;
import com.swp.beans.SeanceHashMap;
import com.swp.sessions.stateless.EnseignantFacade;
import com.swp.sessions.stateless.FiliereFacade;
import com.swp.sessions.stateless.MessageFacade;
import com.swp.sessions.stateless.SeanceFacade;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "SignalerAbscence", urlPatterns = {"/signalerabscence"})
public class SignalerAbscence extends HttpServlet {

    @EJB
    SeanceFacade seanceFacade;
    @EJB
    EnseignantFacade enseignantFacade;
    @EJB
    MessageFacade messageFacade;
    @EJB
    FiliereFacade filiereFacade;
        
    protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    protected void processRequestPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String seanceid = request.getParameter("seancetoabsentid");
        System.out.println(seanceid);
        Seance s = seanceFacade.find(Integer.parseInt(seanceid));
        String nomF = s.getNumEmp().getNumG().getNomFiliere();
        Filiere filiere = filiereFacade.findByNomF(nomF);
        
        Enseignant enschef = filiere.getChef();
        String emailchefdepartement = enschef.getEmail();
        
        Enseignant enscoordinateur = filiere.getCoordinateur();
        String emailcoordinateur = enscoordinateur.getEmail();
        
        String emailgroupe = request.getParameter("emailgroupe");
        
        String message = request.getParameter("message");
        //System.out.println("taille du message " + message.length());
        
        String objetmessage = request.getParameter("objetmessage");
        //System.out.println("taille du objetmessage " + objetmessage.length());
        
        String idEns = getEnseignantInfoCookies(request, "idens");
        Integer ensid = Integer.parseInt(idEns);
        Enseignant ens = enseignantFacade.find(ensid);
        //System.out.println("ensnom  " + ens.getPrenom());
        String nomEns = getEnseignantInfoCookies(request, "nomens");
        String prenomEns = getEnseignantInfoCookies(request, "prenomens");
        String fromWhichEns =  "De la part du professeur " + nomEns + " " + prenomEns;
        String messagetosend = fromWhichEns + "\n" + message;
        //System.out.println("idens = " + idEns);
        //System.out.println("ensid = " + ensid);
        
        String messageD = request.getParameter("messageD");
        System.out.println(messageD);
        String messagetosendD = fromWhichEns + "\n" + messageD;
        
        SendMail.envoyerMail(emailgroupe, objetmessage, messagetosend);
        SendMail.envoyerMail(emailchefdepartement, objetmessage, messagetosendD);
        SendMail.envoyerMail(emailcoordinateur, objetmessage, messagetosendD);
        
        
        
        
        Message msg = new Message();
        Calendar cal = Calendar.getInstance();
        msg.setDate(cal.getTime());
        
        msg.setTypeReceiver("groupe");
        msg.setIdMsg(1);
        msg.setSender(ens);
        msg.setText(message);
        msg.setTime(cal.getTime());
        msg.setObjet(objetmessage);
        msg.setReceiver(emailgroupe);
        System.out.println("before creating");
        messageFacade.create(msg);
        
        Message msgChef = new Message();
        Calendar calChef = Calendar.getInstance();
        msgChef.setDate(cal.getTime());
        
        msgChef.setTypeReceiver("Chef Departement");
        msgChef.setIdMsg(1);
        msgChef.setSender(ens);
        msgChef.setText(message);
        msgChef.setTime(cal.getTime());
        msgChef.setObjet(objetmessage);
        msgChef.setReceiver(emailchefdepartement);
        System.out.println("before creating");
        messageFacade.create(msgChef);
        
        Message msgCoord = new Message();
        Calendar calCoord = Calendar.getInstance();
        msgCoord.setDate(cal.getTime());
        
        msgCoord.setTypeReceiver("Coordinateur Filiere");
        msgCoord.setIdMsg(1);
        msgCoord.setSender(ens);
        msgCoord.setText(message);
        msgCoord.setTime(cal.getTime());
        msgCoord.setObjet(objetmessage);
        msgCoord.setReceiver(emailcoordinateur);
        System.out.println("before creating");
        messageFacade.create(msgCoord);
        
        String semaineid = request.getParameter("currentsemaineid");
        System.out.println("currentsemaineid " + semaineid);
        List<Seance> listSeance = SeanceHashMap.getSeanceEnsBySemaine(ens, semaineid);
        HashMap<String, HashMap<String, Seance>> seanceHashMap = SeanceHashMap.getHashMap(listSeance);
        request.setAttribute("seanceHashMap", seanceHashMap);
        this.getServletContext().getRequestDispatcher("/WEB-INF/viewens/EmploiEns.jsp").forward(request, response);
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequestGet(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequestPost(request, response);
    }

    
    public String getEnseignantInfoCookies(HttpServletRequest request, String cle) {
        Cookie[] cookies = request.getCookies();
        if(cookies != null) {
            for (Cookie cooky : cookies) {
                if(cooky != null && cle.equals(cooky.getName())) {
                    return cooky.getValue();
                }
            }
        }
        return null;
    }
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}