package pl.com.autostopowicz.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import pl.com.autostopowicz.database.DatabaseManager;
import pl.com.autostopowicz.entities.Drive;
import pl.com.autostopowicz.entities.User;

public class AcceptController {
	  //~ Instance fields ------------------------------------------------------------------------------------------------

    /** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());

	private String acceptedUserId;
	
	private String driveId;
	
	private String accept;
	
	private MailSender mailSender;

	private SimpleMailMessage message;
	
	int counter;
    
	
	private boolean activate = false;
	
    public String getPozdrowienia() {
        return "Pozdrowienia od ziarna ze Spring Framework";
    }

    /** TODO: DOCUMENT ME! */
    private DatabaseManager dataSource;

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     *  
    DOCUMENT ME!
     *
     *  @param dataSource the dataSource to set
     */
    public void setDataSource(DatabaseManager dataSource) {
        this.dataSource = dataSource;
    }

	public String getAcceptedUserId() {
		return acceptedUserId;
	}

	public void setAcceptedUserId(String acceptedUserId) {
		this.acceptedUserId = acceptedUserId;
	}

	public String getDriveId() {
		return driveId;
	}

	public void setDriveId(String driveId) {
		this.driveId = driveId;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public boolean isActivate() {
		System.out.println("Test z parametru" + this.acceptedUserId);
		System.out.println("Accept" + this.accept);
		
		counter++; 
		
		
		if (acceptedUserId != null && driveId !=null && accept != null && counter==1) {
			
			if (accept.equals("true")){
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage("Zaakceptowa³eœ u¿ytkownika:"+dataSource.getUser(Integer.parseInt(acceptedUserId)).getLogin()));
			
		    
			
			acceptUser();
			}else{
		    	FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage("U¿ytkonik "+dataSource.getUser(Integer.parseInt(acceptedUserId)).getLogin()+ "nie zosta³ przez ciebie zaakceptowany."));
		    	
		    rejectUser();	
		   
		    }
			

		}
		return true;
	}

	private void rejectUser() {
		Drive drive = (Drive)dataSource.getDrive(Integer.parseInt(driveId));
		String message = "Twoja proœba o do³¹czenie do trasy:\nSkad:"
				+ "\nKraj:" + drive.getCountryFrom().getName() + " Miasto: "
				+ drive.getCityFrom().getName() + " Ulica: " + drive.getStreetFrom()
				+ "\nGdzie:" + "\n" + "\nKraj:" + drive.getCountryTo()
				+ " Miasto: " + drive.getCityTo() + " Ulica: "
				+ drive.getStreetTo()+"\n zosta³a odrzucona"
				+"\nAby wyszukaæ inne po³¹czenia kliknij poni¿szy link"
				+ "http://localhost:8080/Autostopowicz2/jsp/CheckDrives.jsf"
				+ "\nIf the link above does not work then please\n"
				+ "copy the activate link and paste it into the location bar to activate your account:";
		
		String subject = "Autostopowicz: Odrzucona proœba o do³¹czenie do wspólnej podró¿y.";
		User joiningUser = dataSource.getUser(Integer.parseInt(acceptedUserId));
		sendReInformationEmail(joiningUser,message,subject);
	}

	private void acceptUser() {
		dataSource.joinUserToDrive(Integer.parseInt(acceptedUserId),Integer.parseInt(driveId));
		
		Drive drive = (Drive)dataSource.getDrive(Integer.parseInt(driveId));
		
		User driveOwner = dataSource.getUser(drive.getIdUser());
		User joiningUser = dataSource.getUser(Integer.parseInt(acceptedUserId));
		String message = "U¿ytkownik"
		+ "Twoja proœba o do³¹czenie do trasy zosta³a zaakceptowana."
		+ "\nSzczegó³y danego po³¹czenia:"
		+ "Skad:"
			+ "\nKraj:" + drive.getCountryFrom().getName() + " Miasto: "
			+ drive.getCityFrom().getName() + " Ulica: " + drive.getStreetFrom()
			+ "\nGdzie:" + "\n" + "\nKraj:" + drive.getCountryTo()
			+ " Miasto: " + drive.getCityTo() + " Ulica: "
			+ drive.getStreetTo()
			+ "\nCena za kilometr: "+drive.getPrice()
			+ "\nIloœæ wolnych miejsc: "+ drive.getPlaceNumber()
			+ "\nMarka/Model samochodu: " +drive.getCar().getMake()+"/"+ drive.getCar().getModel()
			+"\nNumer rejestracyjny: "+drive.getCar().getNumberPlate()
			+ "\n\nDane Kierowcy: "
			+ "\n  Login:"+ driveOwner.getLogin()
			+ "\n  Imiê:" + driveOwner.getName()
			+ "\n  Nazwisko:" + driveOwner.getSurname()
			+ "\n  Telefon" + driveOwner.getPhone()
			+ "\n  Email:" + driveOwner.getEmail()
			+ "\n  Opis:" + driveOwner.getDescription()
			+"\nAby wyszukaæ inne po³¹czenia kliknij poni¿szy link"
			+ "http://localhost:8080/Autostopowicz2/jsp/CheckDrives.jsf"
			+ "\nIf the link above does not work then please\n"
			+ "copy the activate link and paste it into the location bar to activate your account:";
		String subject = "Autostopowicz: Zaakceptowana proœba o do³¹czenie do wspólnej podró¿y.";
		sendReInformationEmail(joiningUser,message,subject);
	}

	private String sendReInformationEmail(User newUser, String messageText, String subject) {
		String toReturn = "failure";
		SimpleMailMessage msg = new SimpleMailMessage(this.message);
		msg.setSubject(subject);
		msg.setTo(newUser.getEmail());
		msg
				.setText(messageText);
		try {
			mailSender.send(msg);
			toReturn = "success";
			FacesContext
					.getCurrentInstance()
					.addMessage(
							"registerForm",
							new FacesMessage(
									"Email informacyjny zosta³ wys³any."));
		} catch (MailException ex) {
			System.out.println("Register failure");
			FacesContext ctx = FacesContext.getCurrentInstance();
			ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
					"Wys³anie emaila informacyjnego nie powiod³o siê.", null));

		}

		return toReturn;

	}
	
	
	public void setActivate(boolean activate) {
		this.activate = activate;
	}

	public MailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	public SimpleMailMessage getMessage() {
		return message;
	}

	public void setMessage(SimpleMailMessage message) {
		this.message = message;
	}                               
}
