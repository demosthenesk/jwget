import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class AppControler {
    public static int ThreadCounter=0;
    private ArrayList<MyThread> threads = new ArrayList<MyThread>();
    private MyThread myThread;
    private String cmd;
    private String args="";
    private String message="";

    @FXML
    private MenuItem mnuExit;
    @FXML
    private MenuItem mnuRun;
    @FXML
    private MenuItem mnuStop;
    @FXML
    private MenuItem mnuRunAll;
    @FXML
    private MenuItem mnuStopAll;
    @FXML
    private MenuItem mnuRefresh;
    @FXML
    private MenuItem mnuClear;
    @FXML
    private MenuItem mnuDelete;
    @FXML
    private MenuItem mnuAbout;
    @FXML
    private ListView lstJobs;
    @FXML
    private TextArea txtArea;
    @FXML
    private Button btnExit;
    @FXML
    private Button btnRun;
    @FXML
    private Button btnStop;
    @FXML
    private Button btnRunAll;
    @FXML
    private Button btnStopAll;
    @FXML
    private Button btnClear;
    @FXML
    private Button btnDelete;
    @FXML
    private Button btnAbout;
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnAddRun;
    @FXML
    private Button btnPreview;
    @FXML
    private TextField txtJobName;
    @FXML
    private TextField txtURL;
    @FXML
    private TextField txtInputFile;
    @FXML
    private Button btnBrowseInputFile;
    @FXML
    private TextField txtPrefix;
    @FXML
    private Button btnBrowsePrefix;
    @FXML
    private CheckBox chkContinue;
    @FXML
    private CheckBox chkLogFile;
    @FXML
    private TextField txtLogFileFolder;
    @FXML
    private Button btnLogFileFolderBrowse;
    @FXML
    private Button btnRefresh;
    @FXML
    private CheckBox chkLogFileAppend;
    @FXML
    private CheckBox chkForceHtml;
    @FXML
    private CheckBox chkBaseURL;
    @FXML
    private TextField txtBaseURL;
    @FXML
    private TextField txtAdditionalParams;
    @FXML
    private CheckBox chkWait;
    @FXML
    private TextField txtWait;
    @FXML
    private CheckBox chkRandomWait;
    @FXML
    private CheckBox chkLimitRate;
    @FXML
    private TextField txtLimitRate;
    @FXML
    private ComboBox<String> cmbLimitRate;
    @FXML
    private CheckBox chkTries;
    @FXML
    private TextField txtTries;
    @FXML
    private CheckBox chkTimeout;
    @FXML
    private TextField txtTimeout;
    @FXML
    private CheckBox chkServerResponse;
    @FXML
    private CheckBox chkRetryConnRefused;
    @FXML
    private CheckBox chkNoClobber;
    @FXML
    private CheckBox chkTimeStamping;
    @FXML
    private CheckBox chkNoDirectories;
    @FXML
    private CheckBox chkForceDirectories;
    @FXML
    private CheckBox chkCutDirs;
    @FXML
    private TextField txtCutDirs;
    @FXML
    private CheckBox chkNoHostDirs;
    @FXML
    private CheckBox chkHttpUser;
    @FXML
    private TextField txtHttpUser;
    @FXML
    private CheckBox chkHttpPaswd;
    @FXML
    private TextField txtHttpPasswd;
    @FXML
    private CheckBox chkProxyUser;
    @FXML
    private TextField txtProxyUser;
    @FXML
    private CheckBox chkProxyPasswd;
    @FXML
    private TextField txtProxyPasswd;
    @FXML
    private CheckBox chkPostData;
    @FXML
    private TextField txtPostData;
    @FXML
    private CheckBox chkReferer;
    @FXML
    private TextField txtReferer;
    @FXML
    private CheckBox chkCache;
    @FXML
    private CheckBox chkDefaultPage;
    @FXML
    private TextField txtDefaultPage;
    @FXML
    private CheckBox chkAdjustExtension;
    @FXML
    private CheckBox chkNoHttpKeepAlive;
    @FXML
    private CheckBox chkLoadCookies;
    @FXML
    private TextField txtLoadCookies;
    @FXML
    private Button btnLoadCookies;
    @FXML
    private CheckBox chkNoCache;
    @FXML
    private CheckBox chkKeepSessionCookies;
    @FXML
    private CheckBox chkIgnoreLength;
    @FXML
    private CheckBox chkSaveCookies;
    @FXML
    private TextField txtSaveCookies;
    @FXML
    private Button btnSaveCookies;
    @FXML
    private CheckBox chkMaxRedirect;
    @FXML
    private TextField txtMaxRedirect;
    @FXML
    private CheckBox chkSaveHeaders;
    @FXML
    private CheckBox chkUserAgent;
    @FXML
    private ComboBox<String> cmbUserAgent;
    @FXML
    private CheckBox chkContentOnError;
    @FXML
    private CheckBox chkTrusyServerNames;
    @FXML
    private CheckBox chkAuthNoChallenge;
    @FXML
    private CheckBox chkRetryOnHostError;
    @FXML
    private CheckBox chkCompression;
    @FXML
    private ComboBox<String> cmbCompression;
    @FXML
    private CheckBox chkSecureProtocol;
    @FXML
    private ComboBox<String> cmbSecureProtocol;
    @FXML
    private CheckBox chkHttpsOnly;
    @FXML
    private CheckBox chkCiphers;
    @FXML
    private CheckBox chkNoCheckCertificate;
    @FXML
    private CheckBox chkCertificate;
    @FXML
    private TextField txtCertificate;
    @FXML
    private Button btnCertificate;
    @FXML
    private CheckBox chkNoHsts;
    @FXML
    private CheckBox chkCertificateType;
    @FXML
    private ComboBox<String> cmbCertificateType;
    @FXML
    private CheckBox chkPrivateKey;
    @FXML
    private TextField txtPrivateKey;
    @FXML
    private Button btnPrivateKey;
    @FXML
    private CheckBox chkPrivateKeyType;
    @FXML
    private ComboBox<String> cmbPrivateKeyType;
    @FXML
    private CheckBox chkNoWarcCompression;
    @FXML
    private CheckBox chkNoWarcDigests;
    @FXML
    private CheckBox chkWarcCdx;
    @FXML
    private CheckBox chkNoWarcKeepLog;
    @FXML
    private CheckBox chkCaCertificate;
    @FXML
    private TextField txtCaCertificate;
    @FXML
    private Button btnCaCertificate;
    @FXML
    private CheckBox chkCrlFile;
    @FXML
    private TextField txtCrlFile;
    @FXML
    private Button btnCrlFile;
    @FXML
    private CheckBox chkRandomFile;
    @FXML
    private TextField txtRandomFile;
    @FXML
    private Button btnRandomFile;
    @FXML
    private CheckBox chkWarcTempDir;
    @FXML
    private TextField txtWarcTempDir;
    @FXML
    private Button btnWarcTempDir;
    @FXML
    private CheckBox chkWarcDedup;
    @FXML
    private TextField txtWarcDedup;
    @FXML
    private Button btnWarcDedup;
    @FXML
    private CheckBox chkEgdFile;
    @FXML
    private TextField txtEgdFile;
    @FXML
    private Button btnEgdFile;
    @FXML
    private CheckBox chkHstsFile;
    @FXML
    private TextField txtHstsFile;
    @FXML
    private Button btnHstsFile;
    @FXML
    private CheckBox chkWarcFile;
    @FXML
    private TextField txtWarcFile;
    @FXML
    private Button btnWarcFile;
    @FXML
    private CheckBox chkWarcHeader;
    @FXML
    private TextField txtWarcHeader;
    @FXML
    private CheckBox chkWarcMaxSize;
    @FXML
    private TextField txtWarcMaxSize;
    @FXML
    private CheckBox chkFtpUser;
    @FXML
    private TextField txtFtpUser;
    @FXML
    private CheckBox chkFtpPasswd;
    @FXML
    private TextField txtFtpPasswd;
    @FXML
    private CheckBox chkNoRemoveListing;
    @FXML
    private CheckBox chkNoGlob;
    @FXML
    private CheckBox chkNoPassiveFtp;
    @FXML
    private CheckBox chkPreservePermissions;
    @FXML
    private CheckBox chkRetrSymlinks;
    @FXML
    private CheckBox chkFtpsImplicit;
    @FXML
    private CheckBox chkNoFtpsResumeSsl;
    @FXML
    private CheckBox chkFtpsClearDataConnection;
    @FXML
    private CheckBox chkFtpsFallbackToFtp;
    @FXML
    private CheckBox chkRecursive;
    @FXML
    private CheckBox chkLevel;
    @FXML
    private TextField txtLevel;
    @FXML
    private CheckBox chkDeleteAfter;
    @FXML
    private CheckBox chkConvertLinks;
    @FXML
    private CheckBox chkConvertFileOnly;
    @FXML
    private CheckBox chkBackupConverted;
    @FXML
    private CheckBox chkMirror;
    @FXML
    private CheckBox chkPageRequisites;
    @FXML
    private CheckBox chkStrictComments;
    @FXML
    private CheckBox chkRecursiveAcceptList;
    @FXML
    private TextField txtRecursiveAcceptList;
    @FXML
    private CheckBox chkRecursiveRejectList;
    @FXML
    private TextField txtRecursiveRejectList;
    @FXML
    private CheckBox chkAcceptRegex;
    @FXML
    private TextField txtAcceptRegex;
    @FXML
    private CheckBox chkRejectRegex;
    @FXML
    private TextField txtRejectRegex;
    @FXML
    private CheckBox chkRegexType;
    @FXML
    private ComboBox<String> cmbRegexType;
    @FXML
    private CheckBox chkDomains;
    @FXML
    private TextField txtDomains;
    @FXML
    private CheckBox chkExcludeDomains;
    @FXML
    private TextField txtExcludeDomains;
    @FXML
    private CheckBox chkFollowFtp;
    @FXML
    private CheckBox chkFollowTags;
    @FXML
    private TextField txtFollowTags;
    @FXML
    private CheckBox chkIgnoreTags;
    @FXML
    private TextField txtIgnoreTags;
    @FXML
    private CheckBox chkIgnoreCase;
    @FXML
    private CheckBox chkSpanHosts;
    @FXML
    private CheckBox chkRelative;
    @FXML
    private CheckBox chkIncludeDirectories;
    @FXML
    private TextField txtIncludeDirectories;
    @FXML
    private CheckBox chkExcludeDirectories;
    @FXML
    private TextField txtExcludeDirectories;
    @FXML
    private CheckBox chkNoParent;

    public AppControler() throws IOException {

    }

    public void onExit(){
        System.out.println("Exiting...!");
        Platform.exit();
        System.exit(0);
    }

    public void onRun() throws IOException {
        int index = lstJobs.getSelectionModel().getSelectedIndex();
        //return if there is no job
        if (index==-1){
            return;
        }
        //run selected job
        if(!threads.get(index).isAlive() && threads.get(index).isRunning==false){
            try{
                myThread = new MyThread(threads.get(index).cmd, threads.get(index).title);
                myThread.setName(threads.get(index).getName());
                threads.set(index,myThread);
                threads.get(index).ProcessRun();
            } catch (Exception ex) {
                System.err.println(ex.getStackTrace());
            }
        }
        onJobListClicked();
    }

    public void onStop() throws IOException, InterruptedException {
        int index = lstJobs.getSelectionModel().getSelectedIndex();
        //return if there is no job
        if (index==-1){
            return;
        }
        //stop selected job
        if(threads.get(index).isAlive()){
            threads.get(index).ProcessStop();
//            threads.get(index).interrupt();
//            threads.get(index).isRunning=false;
        }
        onJobListClicked();
    }

    public void onRunAll(){
        for(int i =0; i<threads.size(); i++){
            //run selected job
            if(!threads.get(i).isAlive() && threads.get(i).isRunning==false){
                try{
                    myThread = new MyThread(threads.get(i).cmd, threads.get(i).title);
                    myThread.setName(threads.get(i).getName());
                    threads.set(i,myThread);
                    threads.get(i).ProcessRun();
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        onJobListClicked();
    }

    public void onStopAll() throws IOException, InterruptedException {
        for(int i=0; i<threads.size(); i++){
            //stop selected job
            if(threads.get(i).isAlive()){
                threads.get(i).ProcessStop();
//                threads.get(i).interrupt();
//                threads.get(i).isRunning=false;
            }
        }
        onJobListClicked();
    }

    public void onDelete(){
        int index = lstJobs.getSelectionModel().getSelectedIndex();
        //return if there is no job
        if (index==-1){
            return;
        }

        if(!threads.get(index).isAlive()){
            lstJobs.getItems().remove(index);
            threads.remove(index);

            message="Selected job deleted!";
            txtArea.setText(message);
        }
        onJobListClicked();
    }

    public void onClear(){
        boolean hasFinishedJobs=false;
        int i=0;
        //clear Finished jobs
        while (true){
            if(lstJobs.getItems().size()>0){
                if(!threads.get(i).isAlive() && threads.get(i).isRunning==true){
                    //remove job
                    hasFinishedJobs=true;
                    lstJobs.getItems().remove(i);
                    threads.remove(i);
                    i=0;
                }else{
                    i+=1;
                    if(i>=lstJobs.getItems().size()){
                        break;
                    }
                }
            }
            if(i>=lstJobs.getItems().size()){
                break;
            }
        }

        if(hasFinishedJobs){
            //Message user for clear finished jobs
            message="Finished jobs were removed !";
            txtArea.setText(message);
        }

        onJobListClicked();
    }

    public void onAbout(){
        message="jwget app"+
                "\nwget downloader manager"+
                "\nDeveloper demosthenek@gmail.com"+
                "\nGPL"
        ;
        txtArea.setText(message);
    }

    public void onPreview(){
        String jobname = txtJobName.getText();

        //Reset txtArea
        txtArea.setText("");

        //validate txtJobName
        if(jobname==null || jobname.length()==0){
            message="Job Name cannot be empty!\nPlease specify a name.";
            txtArea.setText(message);
            return;
        }
        cmd = getCMD();
        //validate cmd
        if(cmd==null || cmd.length()==0){
            return;
        }

        //Message user for new thread-job
        message="New Job to add : "+txtJobName.getText()+"\nCommand: "+cmd;
        txtArea.setText(message);

    }

    public void onAdd() throws IOException {
        String jobname = txtJobName.getText();

        //Reset txtArea
        txtArea.setText("");

        //validate txtJobName
        if(jobname==null || jobname.length()==0){
            message="Job Name cannot be empty!\nPlease specify a name.";
            txtArea.setText(message);
            return;
        }
        cmd = getCMD();
        //validate cmd
        if(cmd==null || cmd.length()==0){
            return;
        }

        myThread = new MyThread(cmd, txtJobName.getText());
        AppControler.ThreadCounter++;
        myThread.setName("WGET#"+AppControler.ThreadCounter);
        threads.add(myThread);
        lstJobs.getItems().add(myThread.getName()+" "+myThread.title);
        //Message user for new thread-job
        message="New Job added: "+myThread.title+"\nCommand: "+myThread.cmd;
        txtArea.setText(message);
    }

    public void onLogFileFolderBrowse(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(window);
        event.consume();

        if(selectedDirectory != null){
            txtLogFileFolder.setText(selectedDirectory.getAbsolutePath()+"/log.txt");
        }

    }
    public void onAppendLogFile(){
        chkLogFile.setSelected(false);
    }
    public void onLogFile(){
        chkLogFileAppend.setSelected(false);
    }
    public void onBrowseInputFile(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
        if (file!=null){
            txtInputFile.setText(file.getPath());
        }
    }
    public void onBrowsePrefix(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(window);
        event.consume();

        if(selectedDirectory != null){
            txtPrefix.setText(selectedDirectory.getAbsolutePath());
        }
    }
    public static boolean isNumericInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public void onLimitRate(){
        cmbLimitRate.getItems().clear();
        cmbLimitRate.getItems().addAll("bytes","KBytes","MBytes");
        cmbLimitRate.getSelectionModel().select(0);
    }

    private String getCMD(){
        String command="";
        String wget = "wget";
        String sURL = txtURL.getText();
        String sLimitRateBytes="";

        //reset args
        args="";

        //set args

        //-N time stamping
        if(chkTimeStamping.isSelected()==true){
            args+=" -N";
        }

        //-nc no clobber
        if(chkNoClobber.isSelected()==true){
            args+=" -nc";
        }

        //--retry-connrefused
        if(chkRetryConnRefused.isSelected()==true){
            args+=" --retry-connrefused";
        }
        //-S server response
        if(chkServerResponse.isSelected()==true){
            args+=" -S";
        }

        //-T timeout
        if(chkTimeout.isSelected()==true){
            if(isNumericInt(txtTimeout.getText())==false){
                message="Timeout input is not numeric!\nPlease enter an integer number";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " -T "+txtTimeout.getText();
            }
        }

        //-t --tries
        if(chkTries.isSelected()==true){
            if(isNumericInt(txtTries.getText())==false){
                message="Tries input is not numeric!\nPlease enter an integer number";
                txtArea.setText(message);
                command = "";
                return command;
            }
            else{
                args+=" -t "+txtTries.getText();
            }
        }

        //--limit-rate
        if(chkLimitRate.isSelected()==true){
            if(isNumericInt(txtLimitRate.getText())==false){
                message="Limit rate input is not numeric!\nPlease enter an integer number";
                txtArea.setText(message);
                command = "";
                return command;
            }
            else{
                if(cmbLimitRate.getItems().get(cmbLimitRate.getSelectionModel().getSelectedIndex())=="bytes"){
                    args+=" --limite-rate="+txtLimitRate.getText();
                } else if (cmbLimitRate.getItems().get(cmbLimitRate.getSelectionModel().getSelectedIndex())=="KBytes") {
                    sLimitRateBytes="k";
                    args+=" --limite-rate="+txtLimitRate.getText()+sLimitRateBytes;
                } else if (cmbLimitRate.getItems().get(cmbLimitRate.getSelectionModel().getSelectedIndex())=="MBytes") {
                    sLimitRateBytes="m";
                    args+=" --limite-rate="+txtLimitRate.getText()+sLimitRateBytes;
                }
            }
        }

        //--random-wait
        if(chkRandomWait.isSelected()==true){
            args+=" --random-wait";
        }

        //-w wait
        if(chkWait.isSelected()==true){
            if(isNumericInt(txtWait.getText())==false){
                message="Wait input is not numeric!\nPlease enter an integer number";
                txtArea.setText(message);
                command = "";
                return command;
            }
            else{
                args+=" -w "+txtWait.getText();
            }
        }

        //Additional params
        if(txtAdditionalParams.getText().length()>0 && txtAdditionalParams.getText()!=""){
            args += " " + txtAdditionalParams.getText();
        }

        //-B base URL
        if(chkBaseURL.isSelected()==true && txtBaseURL.getText().length()>0 && txtBaseURL.getText()!=""){
            //test valid base URL
            try {
                new URL(txtBaseURL.getText());
            } catch (MalformedURLException malformedURLException) {
                message="Base URL is not valid!\nPlease set a valid Base URL!";
                txtArea.setText(message);
                command = "";
                return command;
            }

            args +=" -B " + txtBaseURL.getText();
        }

        //-F force html
        if(chkForceHtml.isSelected()==true){
            args +=" -F";
        }

        //-a append log file
        if(txtLogFileFolder.getText().length()!=0 && txtLogFileFolder.getText() !="" && chkLogFileAppend.isSelected()==true){
            args +=" -a "+txtLogFileFolder.getText();
        }

        //-o log-file
        if(chkLogFile.isSelected() && txtLogFileFolder.getText().length()>0 && txtLogFileFolder.getText() !="" && chkLogFileAppend.isSelected()==false){
            args +=" -o "+txtLogFileFolder.getText();
        }

        //-c continue
        if(chkContinue.isSelected()==true){
            args +=" -c";
        }

        //-P folder
        if(!(txtPrefix.equals("") || txtPrefix.getText().length()==0)){
            args +=" -P "+txtPrefix.getText();
        }
        
        //if there is -i input-file ignore URL
        if(!(txtInputFile.equals("") || txtInputFile.getText().length()==0)){
            args +=" -i "+txtInputFile.getText();
            command = wget + " " + args;
            return command;
        }

        //validate
        try {
            new URL(sURL);
        } catch (MalformedURLException malformedURLException) {
            message="URL is not valid!\nPlease set a valid URL!";
            txtArea.setText(message);
            command = "";
            return command;
        }
        if (sURL.equals("")){
            message="URL cannot be empty!\nPlease set an URL!";
            txtArea.setText(message);
            command = "";
        }else{
            command = wget + " " + args + " " + sURL;
        }

        return command;
    }

    public void onAddRun() throws IOException {
        onAdd();
        if(threads.size()>0){
            threads.get(threads.size()-1).ProcessRun();
        }
    }

    public void onJobListClicked(){
        boolean isFinished;
        int index = lstJobs.getSelectionModel().getSelectedIndex();
//        System.out.println(index);

        CheckFinishedJobs();

        //return if there is no job
        if (index==-1){
            return;
        }

        if(!threads.get(index).isAlive() && threads.get(index).isRunning==true){
            isFinished = true;
        }else{
            isFinished=false;
        }

        message="Job Name: "+threads.get(index).title+
                "\nCommand: "+threads.get(index).cmd+
                "\nIsAlive: "+threads.get(index).isAlive()+
                "\nFinished: "+ isFinished
        ;
        txtArea.setText(message);
    }

    public void CheckFinishedJobs(){
        if(lstJobs.getItems().size()>0){
            for(int i=0; i<lstJobs.getItems().size(); i++){
                if(!threads.get(i).isAlive() && threads.get(i).isRunning==true){
                    //thread is FINISHED
                    if(!threads.get(i).title.contains("[FINISHED]")){
                        //if thread title does not contain FINISHED
                        lstJobs.getItems().set(i,threads.get(i).getName()+" "+threads.get(i).title + " \n[FINISHED]");
                    }
                }

            }
        }
    }

    public void onRefresh(){
        CheckFinishedJobs();
    }

}
