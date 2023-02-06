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
    @FXML
    private CheckBox chkCaDirectory;
    @FXML
    private TextField txtCaDirectory;
    @FXML
    private Button btnCaDirectory;

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
            txtInputFile.setText(file.getAbsolutePath());
        }
    }
    public void onBrowseSaveCookies(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
        if (file!=null){
            txtSaveCookies.setText(file.getAbsolutePath());
        }
    }
    public void onBrowseLoadCookies(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
        if (file!=null){
            txtLoadCookies.setText(file.getAbsolutePath());
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

    public void onCompression(){
        cmbCompression.getItems().clear();
        cmbCompression.getItems().addAll("auto","gzip","none");
        cmbCompression.getSelectionModel().select(0);
    }

    public void onUserAgent(){
        cmbUserAgent.getItems().clear();
        cmbUserAgent.getItems().addAll(
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:53.0) Gecko/20100101 Firefox/53.0",
                "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393",
                "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)",
                "Mozilla/5.0 (Windows; U; MSIE 7.0; Windows NT 6.0; en-US)",
                "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 5.1; Trident/4.0; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)",
                "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.0; Trident/5.0;  Trident/5.0)",
                "Mozilla/5.0 (compatible; MSIE 10.0; Windows NT 6.2; Trident/6.0; MDDCJS)",
                "Mozilla/5.0 (compatible, MSIE 11, Windows NT 6.3; Trident/7.0; rv:11.0) like Gecko",
                "Mozilla/5.0 (iPad; CPU OS 8_4_1 like Mac OS X) AppleWebKit/600.1.4 (KHTML, like Gecko) Version/8.0 Mobile/12H321 Safari/600.1.4",
                "Mozilla/5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/10.0 Mobile/14E304 Safari/602.1",
                "Mozilla/5.0 (compatible; Googlebot/2.1; +http://www.google.com/bot.html)",
                "Mozilla/5.0 (compatible; bingbot/2.0; +http://www.bing.com/bingbot.htm)",
                "Mozilla/5.0 (Linux; Android 6.0.1; SAMSUNG SM-G570Y Build/MMB29K) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/4.0 Chrome/44.0.2403.133 Mobile Safari/537.36",
                "Mozilla/5.0 (Linux; Android 5.0; SAMSUNG SM-N900 Build/LRX21V) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/2.1 Chrome/34.0.1847.76 Mobile Safari/537.36",
                "Mozilla/5.0 (Linux; Android 6.0.1; SAMSUNG SM-N910F Build/MMB29M) AppleWebKit/537.36 (KHTML, like Gecko) SamsungBrowser/4.0 Chrome/44.0.2403.133 Mobile Safari/537.36",
                "Mozilla/5.0 (Linux; U; Android-4.0.3; en-us; Galaxy Nexus Build/IML74K) AppleWebKit/535.7 (KHTML, like Gecko) CrMo/16.0.912.75 Mobile Safari/535.7",
                "Mozilla/5.0 (Linux; Android 7.0; HTC 10 Build/NRD90M) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.83 Mobile Safari/537.36",
                "curl/7.35.0",
                "Wget/1.15 (linux-gnu)",
                "Lynx/2.8.8pre.4 libwww-FM/2.14 SSL-MM/1.4.1 GNUTLS/2.12.23"
        );
        cmbUserAgent.getSelectionModel().select(0);
    }
    public void onSecureProtocol(){
        cmbSecureProtocol.getItems().clear();
        cmbSecureProtocol.getItems().addAll(
                "auto",
                "SSLv2",
                "SSLv3",
                "TLSv1",
                "TLSv1_1",
                "TLSv1_2",
                "TLSv1_3",
                "PFS"
        );
        cmbSecureProtocol.getSelectionModel().select(0);
    }
    public void onCertificateType(){
        cmbCertificateType.getItems().clear();
        cmbCertificateType.getItems().addAll(
                "PEM",
                "DER",
                "ASN1"
        );
        cmbCertificateType.getSelectionModel().select(0);
    }
    public void onPrivateKeyType(){
        cmbPrivateKeyType.getItems().clear();
        cmbPrivateKeyType.getItems().addAll(
                "DER",
                "PEM"
        );
        cmbPrivateKeyType.getSelectionModel().select(0);
    }
    public void onRegexType(){
        cmbRegexType.getItems().clear();
        cmbRegexType.getItems().addAll(
                "posix",
                "pcre"
        );
        cmbRegexType.getSelectionModel().select(0);
    }
    public void onBrowseCertificate(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
        if (file!=null){
            txtCertificate.setText(file.getAbsolutePath());
        }
    }
    public void onBrowsePrivateKey(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
        if (file!=null){
            txtPrivateKey.setText(file.getAbsolutePath());
        }
    }
    public void onBrowseCrlFile(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
        if (file!=null){
            txtCrlFile.setText(file.getAbsolutePath());
        }
    }
    public void onBrowseRandomFile(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
        if (file!=null){
            txtRandomFile.setText(file.getAbsolutePath());
        }
    }
    public void onBrowseWarcTempDir(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(window);
        event.consume();

        if(selectedDirectory != null){
            txtWarcTempDir.setText(selectedDirectory.getAbsolutePath());
        }
    }
    public void onBrowseCaDirectory(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory = directoryChooser.showDialog(window);
        event.consume();

        if(selectedDirectory != null){
            txtCaDirectory.setText(selectedDirectory.getAbsolutePath());
        }
    }
    public void onBrowseWarcDedup(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
        if (file!=null){
            txtWarcDedup.setText(file.getAbsolutePath());
        }
    }
    public void onBrowseHstsFile(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
        if (file!=null){
            txtHstsFile.setText(file.getAbsolutePath());
        }
    }
    public void onBrowseWarcFile(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
        if (file!=null){
            txtWarcFile.setText(file.getAbsolutePath());
        }
    }
    public void onBrowseEgdFile(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
        if (file!=null){
            txtEgdFile.setText(file.getAbsolutePath());
        }
    }
    public void onBrowseCaCertificate(ActionEvent event){
        Window window = ((Node) (event.getSource())).getScene().getWindow();
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(window);
        event.consume();
        if (file!=null){
            txtCaCertificate.setText(file.getAbsolutePath());
        }
    }

    private String getCMD(){
        String command="";
        String wget = "wget";
        String sURL = txtURL.getText();
        String sLimitRateBytes="";

        //reset args
        args="";

        //set args

        //[-np] no-parent
        if(chkNoParent.isSelected()==true){
            args+=" -np";
        }

        //[-X] exclude directories
        if(chkExcludeDirectories.isSelected()==true){
            if(txtExcludeDirectories.getText().length()==0 || txtExcludeDirectories.getText()==""){
                message="Exclude directories input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --exclude-directories="+"\""+txtExcludeDirectories.getText()+"\"";
            }
        }

        //[-I] --include-directories
        if(chkIncludeDirectories.isSelected()==true){
            if(txtIncludeDirectories.getText().length()==0 || txtIncludeDirectories.getText()==""){
                message="Include directories input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --include-directories="+"\""+txtIncludeDirectories.getText()+"\"";
            }
        }

        //[-L] relative
        if(chkRelative.isSelected()==true){
            args+=" -L";
        }

        //[-H] span hosts
        if(chkSpanHosts.isSelected()==true){
            args+=" -H";
        }

        //--ignore-case
        if(chkIgnoreCase.isSelected()==true){
            args+=" --ignore-case";
        }

        //--ignore-tags
        if(chkIgnoreTags.isSelected()==true){
            if(txtIgnoreTags.getText().length()==0 || txtIgnoreTags.getText()==""){
                message="Ignore tags input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --ignore-tags="+txtIgnoreTags.getText();
            }
        }

        //--follow-tags
        if(chkFollowTags.isSelected()==true){
            if(txtFollowTags.getText().length()==0 || txtFollowTags.getText()==""){
                message="Follow tags input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --follow-tags="+txtFollowTags.getText();
            }
        }

        //--follow-ftp
        if(chkFollowFtp.isSelected()==true){
            args+=" --follow-ftp";
        }

        //--exclude-domains
        if(chkExcludeDomains.isSelected()==true){
            if(txtExcludeDomains.getText().length()==0 || txtExcludeDomains.getText()==""){
                message="Exclude domains input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --exclude-domains="+txtExcludeDomains.getText();
            }
        }

        //[-D] domains
        if(chkDomains.isSelected()==true){
            if(txtDomains.getText().length()==0 || txtRejectRegex.getText()==""){
                message="Domains input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " -D "+txtDomains.getText();
            }
        }

        //--regex-type
        if(chkRegexType.isSelected()==true){
            args +=" --regex-type " + cmbRegexType.getItems().get(cmbRegexType.getSelectionModel().getSelectedIndex());
        }

        //--reject-regex
        if(chkRejectRegex.isSelected()==true){
            if(txtRejectRegex.getText().length()==0 || txtRejectRegex.getText()==""){
                message="Reject regex input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --reject-regex "+"\""+txtRejectRegex.getText()+"\"";
            }
        }

        //--accept-regex
        if(chkAcceptRegex.isSelected()==true){
            if(txtAcceptRegex.getText().length()==0 || txtAcceptRegex.getText()==""){
                message="Accept regex input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --accept-regex "+"\""+txtAcceptRegex.getText()+"\"";
            }
        }

        //[-R] recursive reject list
        if(chkRecursiveRejectList.isSelected()==true){
            if(txtRecursiveRejectList.getText().length()==0 || txtRecursiveRejectList.getText()==""){
                message="Recursive reject list input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " -R "+"\""+txtRecursiveRejectList.getText()+"\"";
            }
        }

        //[-A] recursive accept list
        if(chkRecursiveAcceptList.isSelected()==true){
            if(txtRecursiveAcceptList.getText().length()==0 || txtRecursiveAcceptList.getText()==""){
                message="Recursive accept list input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " -A "+"\""+txtRecursiveAcceptList.getText()+"\"";
            }
        }


        //--strict-comments
        if(chkStrictComments.isSelected()==true){
            args+=" --strict-comments";
        }

        //[-p] page requisites
        if(chkPageRequisites.isSelected()==true){
            args+=" -p";
        }

        //[-m] mirror
        if(chkMirror.isSelected()==true){
            args+=" -m";
        }

        //[-K] backup converted
        if(chkBackupConverted.isSelected()==true){
            args+=" -K";
        }

        //--convert-file-only
        if(chkConvertFileOnly.isSelected()==true){
            args+=" --convert-file-only";
        }

        //[-k] convert links
        if(chkConvertLinks.isSelected()==true){
            args+=" -k";
        }

        //--delete-after
        if(chkDeleteAfter.isSelected()==true){
            args+=" --delete-after";
        }

        //-l level
        if(chkLevel.isSelected()==true){
            if(isNumericInt(txtLevel.getText())==false){
                message="Level input is not numeric!\nPlease enter an integer number";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " -l "+txtLevel.getText();
            }
        }


        //[-r] recursive
        if(chkRecursive.isSelected()==true){
            args+=" -r";
        }

        //--ftps-fallback-to-ftp
        if(chkFtpsFallbackToFtp.isSelected()==true){
            args+=" --ftps-fallback-to-ftp";
        }

        //--ftps-clear-data-connection
        if(chkFtpsClearDataConnection.isSelected()==true){
            args+=" --ftps-clear-data-connection";
        }

        //--no-ftps-resume-ssl
        if(chkNoFtpsResumeSsl.isSelected()==true){
            args+=" --no-ftps-resume-ssl";
        }

        //--ftps-implicit
        if(chkFtpsImplicit.isSelected()==true){
            args+=" --ftps-implicit";
        }

        //--retr-symlinks
        if(chkRetrSymlinks.isSelected()==true){
            args+=" --retr-symlinks";
        }

        //--preserve-permissions
        if(chkPreservePermissions.isSelected()==true){
            args+=" --preserve-permissions";
        }

        //--no-passive-ftp
        if(chkNoPassiveFtp.isSelected()==true){
            args+=" --no-passive-ftp";
        }

        //--no-glob
        if(chkNoGlob.isSelected()==true){
            args+=" --no-glob";
        }

        //--no-remove-listing
        if(chkNoRemoveListing.isSelected()==true){
            args+=" --no-remove-listing";
        }

        //--ftp-user
        if(chkFtpUser.isSelected()==true){
            if(txtFtpUser.getText().length()==0 || txtFtpUser.getText()==""){
                message="Ftp user input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --ftp-user="+txtFtpUser.getText();
            }
        }

        //--ftp-password
        if(chkFtpPasswd.isSelected()==true){
            if(txtFtpPasswd.getText().length()==0 || txtFtpPasswd.getText()==""){
                message="Ftp user input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --ftp-password="+txtFtpPasswd.getText();
            }
        }


        //--ca-directory
        if(chkCaDirectory.isSelected()==true){
            if(txtCaDirectory.getText().length()==0 || txtCaDirectory.getText()==""){
                message="Ca directory input is not valid!\nPlease browse for a folder.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --ca-directory="+txtCaDirectory.getText();
            }
        }

        //--egd-file
        if(chkEgdFile.isSelected()==true){
            if(txtEgdFile.getText().length()==0 || txtEgdFile.getText()==""){
                message="Egd file input is not valid!\nPlease browse for a file.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --egd-file="+txtEgdFile.getText();
            }
        }


        //--warc-max-size
        if(chkWarcMaxSize.isSelected()==true){
            if(isNumericInt(txtWarcMaxSize.getText())==false){
                message="Warc max size input is not numeric!\nPlease enter an integer number";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --warc-max-size="+txtWarcMaxSize.getText();
            }
        }

        //--warc-header
        if(chkWarcHeader.isSelected()==true){
            if(txtWarcHeader.getText().length()==0 || txtWarcHeader.getText()==""){
                message="Warc header input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --warc-header=\""+txtWarcHeader.getText()+"\"";
            }
        }


        //--warc-file
        if(chkWarcFile.isSelected()==true){
            if(txtWarcFile.getText().length()==0 || txtWarcFile.getText()==""){
                message="Warc file input is not valid!\nPlease browse for a file.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --warc-file="+txtWarcFile.getText();
            }
        }


        //--hsts-file
        if(chkHstsFile.isSelected()==true){
            if(txtHstsFile.getText().length()==0 || txtHstsFile.getText()==""){
                message="Hsts file input is not valid!\nPlease browse for a file.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --hsts-file="+txtHstsFile.getText();
            }
        }


        //--warc-dedup
        if(chkWarcDedup.isSelected()==true){
            if(txtWarcDedup.getText().length()==0 || txtWarcDedup.getText()==""){
                message="Warc dedup file input is not valid!\nPlease browse for a file.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --warc-dedup="+txtWarcDedup.getText();
            }
        }


        //--warc-tempdir
        if(chkWarcTempDir.isSelected()==true){
            if(txtWarcTempDir.getText().length()==0 || txtWarcTempDir.getText()==""){
                message="Warc Temp Dit input is not valid!\nPlease browse for a folder.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --warc-tempdir="+txtWarcTempDir.getText();
            }
        }

        //--crl-file
        if(chkCrlFile.isSelected()==true){
            if(txtCrlFile.getText().length()==0 || txtCrlFile.getText()==""){
                message="Crl file input is not valid!\nPlease browse for a file.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --crl-file="+txtCrlFile.getText();
            }
        }

        //--ca-certificate
        if(chkCaCertificate.isSelected()==true){
            if(txtCaCertificate.getText().length()==0 || txtCaCertificate.getText()==""){
                message="Ca Certificate input is not valid!\nPlease browse for a file.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --ca-certificate="+txtCaCertificate.getText();
            }
        }

        //--no-warc-keep-log
        if(chkNoWarcKeepLog.isSelected()==true){
            args+=" --no-warc-keep-log";
        }

        //--warc-cdx
        if(chkWarcCdx.isSelected()==true){
            args+=" --warc-cdx";
        }

        //--no-warc-digests
        if(chkNoWarcDigests.isSelected()==true){
            args+=" --no-warc-digests";
        }

        //--no-warc-compression
        if(chkNoWarcCompression.isSelected()==true){
            args+=" --no-warc-compression";
        }

        //--private-key-type
        if(chkPrivateKeyType.isSelected()==true){
            args +=" --private-key-type=" + cmbPrivateKeyType.getItems().get(cmbPrivateKeyType.getSelectionModel().getSelectedIndex());
        }

        //--private-key
        if(chkPrivateKey.isSelected()==true){
            if(txtPrivateKey.getText().length()==0 || txtPrivateKey.getText()==""){
                message="Certificate input is not valid!\nPlease browse for a file.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --private-key="+txtPrivateKey.getText();
            }
        }

        //--certificate-type
        if(chkCertificateType.isSelected()==true){
            args +=" --certificate-type=" + cmbCertificateType.getItems().get(cmbCertificateType.getSelectionModel().getSelectedIndex());
        }

        //--no-hsts
        if(chkNoHsts.isSelected()==true){
            args+=" --no-hsts";
        }

        //--certificate
        if(chkCertificate.isSelected()==true){
            if(txtCertificate.getText().length()==0 || txtCertificate.getText()==""){
                message="Certificate input is not valid!\nPlease browse for a file.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --certificate="+txtCertificate.getText();
            }
        }


        //--no-check-certificate
        if(chkNoCheckCertificate.isSelected()==true){
            args +=" --no-check-certificate";
        }

        //--ciphers
        if(chkCiphers.isSelected()==true){
            args +=" --ciphers";
        }

        //--https-only
        if(chkHttpsOnly.isSelected()==true){
            args +=" --https-only";
        }

        //--secure-protocol
        if(chkSecureProtocol.isSelected()==true){
            args +=" --secure-protocol=" + cmbSecureProtocol.getItems().get(cmbSecureProtocol.getSelectionModel().getSelectedIndex());
        }

        //-compression
        if(chkCompression.isSelected()==true){
            args +=" --compression=" + cmbCompression.getItems().get(cmbCompression.getSelectionModel().getSelectedIndex());
        }


        //--retry-on-host-error
        if(chkRetryOnHostError.isSelected()==true){
            args +=" --retry-on-host-error";
        }

        //--auth-no-challenge
        if(chkAuthNoChallenge.isSelected()==true){
            args +=" --auth-no-challenge";
        }

        //--trust-server-names
        if(chkTrusyServerNames.isSelected()==true){
            args +=" --trust-server-names";
        }

        //--content-on-error
        if(chkContentOnError.isSelected()==true){
            args +=" --content-on-error";
        }

        //-U user agent
        if(chkUserAgent.isSelected()==true){
            args +=" -U \"" + cmbUserAgent.getItems().get(cmbUserAgent.getSelectionModel().getSelectedIndex())+"\"";
        }


        //--save-headers
        if(chkSaveHeaders.isSelected()==true){
            args +=" --save-headers";
        }

        //--max-redirect
        if(chkMaxRedirect.isSelected()==true){
            if(isNumericInt(txtMaxRedirect.getText())==false){
                message="Max redirect input is not numeric!\nPlease enter an integer number";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --max-redirect="+txtMaxRedirect.getText();
            }
        }


        //--ignore-length
        if(chkIgnoreLength.isSelected()==true){
            args +=" --ignore-length";
        }

        //--keep-session-cookies
        if(chkKeepSessionCookies.isSelected()==true){
            args +=" --keep-session-cookies";
        }

        //--no-cache
        if(chkNoCache.isSelected()==true){
            args += " --no-cache";
        }

        //--save-cookies
        if(chkSaveCookies.isSelected()==true){
            if(txtSaveCookies.getText().length()==0 || txtSaveCookies.getText()==""){
                message="Save cookies input is not valid!\nPlease browse for a save cookie file.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --save-cookies "+txtSaveCookies.getText();
            }
        }

        //--load-cookies
        if(chkLoadCookies.isSelected()==true){
            if(txtLoadCookies.getText().length()==0 || txtLoadCookies.getText()==""){
                message="Load cookies input is not valid!\nPlease browse for a cookie file.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --load-cookies "+txtLoadCookies.getText();
            }
        }

        //--no-http-keep-alive
        if(chkNoHttpKeepAlive.isSelected()==true){
            args +=" --no-http-keep-alive";
        }

        //-E adjust extension
        if(chkAdjustExtension.isSelected()==true){
            args +=" -E";
        }

        //--default-page
        if(chkDefaultPage.isSelected()==true){
            if(txtDefaultPage.getText().length()==0 || txtDefaultPage.getText()==""){
                message="Default page input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --default-page="+txtDefaultPage.getText();
            }
        }

        //--cache
        if(chkCache.isSelected()==true){
            args +=" --cache";
        }

        //--referer
        if(chkReferer.isSelected()==true){
            if(txtReferer.getText().length()==0 || txtReferer.getText()==""){
                try {
                    new URL(txtReferer.getText());
                } catch (MalformedURLException malformedURLException) {
                    message="Referer URL is not valid!\nPlease set a valid URL!";
                    txtArea.setText(message);
                    command = "";
                    return command;
                }
                args += " --referer="+txtReferer.getText();
            }
        }

        //--post-data
        if(chkPostData.isSelected()==true){
            if(txtPostData.getText().length()==0 || txtPostData.getText()==""){
                message="Post data input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --post-data=\""+txtPostData.getText()+"\"";
            }
        }

        //--proxy-passwd
        if(chkProxyPasswd.isSelected()==true){
            if(txtProxyPasswd.getText().length()==0 || txtProxyPasswd.getText()==""){
                message="Proxy password input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --proxy-passwd="+txtProxyPasswd.getText();
            }
        }

        //--proxy-user
        if(chkProxyUser.isSelected()==true){
            if(txtProxyUser.getText().length()==0 || txtProxyUser.getText()==""){
                message="Proxy user input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --proxy-user="+txtProxyUser.getText();
            }
        }

        //--http-passwd
        if(chkHttpPaswd.isSelected()==true){
            if(txtHttpPasswd.getText().length()==0 || txtHttpPasswd.getText()==""){
                message="Http password input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --http-passwd="+txtHttpPasswd.getText();
            }
        }

        //--http-user
        if(chkHttpUser.isSelected()==true){
            if(txtHttpUser.getText().length()==0 || txtHttpUser.getText()==""){
                message="Http user input is not valid!\nPlease enter a text value.";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --http-user="+txtHttpUser.getText();
            }
        }

        //-cut dirs
        if(chkCutDirs.isSelected()==true){
            if(isNumericInt(txtCutDirs.getText())==false){
                message="Cut directories input is not numeric!\nPlease enter an integer number";
                txtArea.setText(message);
                command = "";
                return command;
            }else{
                args += " --cut-dirs="+txtCutDirs.getText();
            }
        }

        //-nH No Host Dirs
        if(chkNoHostDirs.isSelected()==true){
            args += " -nH";
        }

        //-x force dirs
        if(chkForceDirectories.isSelected()==true){
            args += " -x";
        }

        //-nd no dirs
        if(chkNoDirectories.isSelected()==true){
            args +=" -nd";
        }

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
