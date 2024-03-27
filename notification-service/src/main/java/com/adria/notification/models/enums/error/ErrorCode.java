package com.adria.notification.models.enums.error;

import lombok.Getter;

import static com.adria.notification.models.enums.error.DetailedErrorCode.*;

/**
 * <p>Enumerator that covers various error codes and their default messages</p>
 * <p>These error codes should be used when throwing a customized business exception</p>
 * <p>These error codes are categorized for each business model</p>
 */
@Getter
public enum ErrorCode {

    // Transaction Error codes
    TRANSACTION_NOT_FOUND_ID(ERR_TR_0001, "Transaction ID not found !", "Transaction Introuvable !"),
    TRANSACTION_NOT_FOUND_SIGNATURE_IMAGE(ERR_TR_0002, "Transaction has no Signature Image !", "Transaction n'a pas d'Image de Signature !"),
    TRANSACTION_NOT_FOUND_EVIDENCE_RECORD(ERR_TR_0003, "Transaction has no Evidence Record !", "Transaction n'a pas de Dossier de Preuve !"),
    TRANSACTION_CREATION_VISIBLE_FAILED(ERR_TR_0004, "Transaction creation failed,you don't have the option to visibly initialise the transaction !",
            "La création de la transaction a échoué, vous n'avez pas la possibilité d'initialiser visiblement une transaction !"),
    TRANSACTION_CREATION_INVISIBLE_FAILED(ERR_TR_0005, "Transaction creation failed,you don't have the option to invisibly initialise the transaction !",
            "La création de la transaction a échoué, vous n'avez pas la possibilité d'initialiser invisiblement une transaction !"),
    TRANSACTION_APPROVAL_FAILED(ERR_TR_0006, "Transaction approval failed, you don't have the permission to choose this signature option !",
            "L'approbation de la transaction a échoué, vous n'avez pas la possibilité de choisir cette option de signature !"),
    TRANSACTION_UNAUTHORIZED_APPROVAL_CANCEL(ERR_TR_0007, "Transaction has either already been approved or is no longer valid !", "Transaction Déjà Approuvée ou Invalide !"),
    TRANSACTION_UNAUTHORIZED_FINISH(ERR_TR_0008, "The transaction is already finished or is no longer valid!", "La transaction est déjà terminée ou n'est plus valide !"),
    TRANSACTION_UNAUTHORIZED_KEYSTORE_OPERATION(ERR_TR_0009, "This signature mode is not allowed for this type of transaction !", "Ce mode de signature n'est pas autorisé pour ce type de transaction !"),
    TRANSACTION_UNAUTHORIZED_PKCS11_OPERATION(ERR_TR_0010, "PKCS11 Operation not allowed for this type of Transaction !", "Opération PKCS11 non Autorisée !"),
    TRANSACTION_ORIGIN_MISS_MATCH(ERR_TR_0011, "The transaction's origin doesn't match that of the consent page !", "L'origine de la transaction ne correspond pas à celle de la page de consentement !"),
    TRANSACTION_NOT_FINISHED(ERR_TR_0012, "Transaction is not finished !", "Transaction Inachevée !"),
    TRANSACTION_OTP_INCORRECT(ERR_TR_0013, "The given password is incorrect, Recheck Password !", "OTP Incorrect, Veuillez réessayez à nouveau !"),
    TRANSACTION_OTP_FAILED(ERR_TR_0014, "The given password is incorrect and there is no remaining attempts, Transaction was Canceled !", "OTP Incorrect, Vous n'avez plus de Tentatives, Transaction Annulée !"),
    TRANSACTION_FAILED(ERR_TR_0015, "Unexpected error occurred, Transaction was Cancelled !", "Une erreur est survenue, prière de réessayer ultérieurement !"),
    TRANSACTION_SIGNATURE_POSITION_OVERLAP_ERROR(ERR_TR_0016, "Signature position is overlapping with an existing document field or invalid!", "Positionnement de signature est en chevauchement avec une donnée existante ou invalide !"),
    TRANSACTION_SIGNATURE_PARAMS_ERROR(ERR_TR_0017, "Default signature parameters are not valid or not found ! please provide signature parameters", "Les paramètres de signature par défaut ne sont pas valides ou sont indisponibles ! veuillez fournir les paramètres de signature !"),
    TRANSACTION_MAXIMUM_NUMBER_ERROR(ERR_TR_0017, "You've reached the maximum number of transactions for today !", "Vous avez atteint le nombre maximal des transactions pour aujourd'hui !"),
    TRANSACTION_OPTIMISTIC_LOCKING_FAILURE(ERR_TR_0019, Constants.DEFAULT_GENERIC_ENG_MESSAGE, Constants.DEFAULT_GENERIC_FR_MESSAGE),
    TRANSACTION_DOCUMENTS_SHOULD_VISUALIZE(ERR_TR_0020, "The documents in this transaction should be visualized !", "Les documents associés à cette transaction doivent être visualisés !"),
    TRANSACTION_FILES_ERROR(ERR_TR_0021, " Error during the saving of files !", " Un problème est engendré durant le sauvgarde des fichiers !"),
    TRANSACTION_SIGNATURE_TSP_ERROR(ERR_TR_0022, "An error occurred during signature timestamp !", "Une erreur est survenue lors l'horodatage de la signature !"),
    TRANSACTION_MAXIMUM_DOCUMENTS_ERROR(ERR_TR_0023, "You've exceeded the maximum number of documents per transaction !", "Vous avez dépassé le nombre maximal des documents par transaction !"),
    TRANSACTION_KYC_SESSION_INVALID(ERR_TR_0024, "Signatory Data verification is either invalid or has expired !", "La vérification des données du signataire est invalide ou expirée !"),
    TRANSACTION_UNAUTHORIZED_RESET(ERR_TR_0025, "The transaction can't be reset !", "La transaction ne peut pas être réinitialisée !"),
    TRANSACTION_KYC_CONFIGURATION_MISSING_INFORMATION(ERR_TR_0026, "Scope configurations are messing and there is no default configuration found ! ",
            "Les configurations scope sont manquantes et il n'y a pas de configuration par défaut trouvée !"),
    TRANSACTION_SIGNATURE_OPTIONS_MISSING(ERR_TR_0027, "You can't update transaction signature options, signature options are missing ! ",
            "Vous ne pouvez pas mettre à jour les options de signature de la transaction, les options de signature sont manquantes."),
    TRANSACTION_UNAUTHORIZED_SEAL_OPERATION(ERR_TR_0028, "Seal configuration is not provided for this client application !", "La configuration Seal n'est pas fournie pour cette application cliente !"),
    TRANSACTION_DOCUMENTS_NOT_COMPLETED(ERR_TR_0029, "There are unsigned or sealed documents, please restart your transaction !", "Il y a des documents non signés ou cachetés, veuillez relancer votre transaction à nouveau !"),
    TRANSACTION_FILES_INVALID(ERR_TR_0030,"Transaction files should have either one zip file or a list of simple files !","Les fichiers de transaction doivent avoir un seul fichier zip ou plusieurs fichers simples !"),
    TRANSACTION_FILES_TYPES_INVALID(ERR_TR_0031 , "Transaction files types should be one of the following types" , "Les types des fichiers de transaction doivent être parmis les types suivants "  ),
    TRANSACTION_FILES_SIZE_INVALID(ERR_TR_0032,"Transaction files size must be less than ","La taille des fichier de la taransaciton doivent être moins de"),
    TRANSACTION_FILES_MAX_NUMBER_ERROR( ERR_TR_0033, "The maximum allowed number of files is " , "Le nombre maximum des fichiers est "),
    UNAUTHORIZED_ADD_TRANSACTION( ERR_TR_0034, "Client unauthorized to add transaction !","Le cient n'est pas autorisé pour ajouter un transaciton !"),
    ID_VERIFICATION_TRANSACTION_FILES_INVALID(ERR_TR_0035 , "Files mut have at lest one Id card photo and 2 selfies !", "La list des fichiers doit contenir au minimum une photo de la carte d'identité et 2 selfies !"),
    OCR_TRANSACTION_FILES_INVALID( ERR_TR_0036, "Front image is required ","L'image de face est obligatoire !"),
    OCR_TRANSACTION_FILES_NOT_ACCEPTABLE( ERR_TR_0038, " The files sent are not acceptable ","Les fichiers que vous avez envoyez sont inacceptables !"),
    // ClientApplication error codes
    CLIENT_APPLICATION_NOT_FOUND_ID(ERR_APP_0001, "Client application is not found !", "L'application client est introuvable !"),
     CLIENT_APPLICATION_NOT_FOUND_CODE(ERR_APP_0002, "Client application is not found !", "L'application client est introuvable !"),
    CLIENT_APPLICATION_INVALID(ERR_APP_0003, "Client Application is deleted or disabled !", "Application Cliente est désactivée !"),
    CLIENT_APPLICATION_CREATION_FAILED(ERR_APP_0004, "Client Application creation failed !", "La création de l'application client a échoué !"),
    CLIENT_APPLICATION_FAILED_AUTHENTICATION(ERR_APP_0005, "CodeApp or Secret is Incorrect", "Code ou Secret Incorrect !"),
    CLIENT_APPLICATION_LOCKED(ERR_APP_0006, "Client Application is Locked for 1 minute !", "Application Cliente est bloquée pour 1 minute !"),
    CLIENT_APPLICATION_SEAL_CONFIGURATION(ERR_APP_0007, "Missing client application seal configuration", "Les paramètres de configuration de cachetage est introuvable"),
    CLIENT_APPLICATION_UNAUTHORIZED(ERR_APP_0008 , "Application belongs to another client" , "L'application est possédée par un autre client"),
    CLIENT_APPLICATION_CODE_EXISTS(ERR_APP_0009 , "Application code is asociated with another application" , "Le code est dèja associée a une application"),
    CLIENT_APPLICATION_LABEL_EXISTS(ERR_APP_0010 , "Application label is asociated with another application" , "Le libellé est dèja associée a une application"),
    CLIENT_APPLICATION_NOT_AUTHORIZED(ERR_APP_0011 , "Application unauthorized" , "L'accès a cette application n'est pas autorisé"),
    CLIENT_APPLICATION_FAILED_DELETE(ERR_APP_0012,"This application couldn't be deleted","Cette application ne peut pas être supprimée!"),
    CLIENT_APPLICATION_NOT_ACTIVE(ERR_APP_0013 , "This application is not active" , "Cette application client est désactivée!"),
    CLIENT_APPLICATION_STATUS_DISABLED(ERR_APP_0014, "The owner of the application is disabled", "L'entreprise propriètaire de l'application est désactivé!"),
    CLIENT_APPLICATION_CODE_NOT_VALID(ERR_APP_0015,"The code is not valid !","Le code doit avoir une longueur minimale de 5 caractères !"),
    CLIENT_APPLICATION_SECRET_NOT_VALID(ERR_APP_0016,"The secret is not valid !","Le secret doit avoir une longueur minimale de 8 caractères !"),
    // client error codes

    CLIENT_NOT_FOUND_ID(ERR_CL_0001 , "Client is not found ","Le client est introuvable"),
    CLIENT_COMPANY_NAME_EXISTS(ERR_CL_0002 , "Company name is associated with another client." , "La raison sociale est dèja associée à un client"),
    CLIENT_NOT_ACCESSIBLE(ERR_CL_0003,"You can't perform actions on this client" , "Vous n'êtes pas autorisés pour affecter un traitement sur ce client" ),
    CLIENT_COULD_NOT_BE_DELETED(ERR_CL_0004, "This client coudn't be deleted" , "Impossible de supprimer ce client "),

    // Profile error Codes
    PROFILE_NOT_FOUND_ID(ERR_PR_0001 , "Profile is not found" , "Le profil est introuvalbe "),

    // AccountUser error codes
    ACCOUNT_USER_NOT_FOUND_USER_NAME(ERR_AU_0001, "Sorry, we could not find your account. Username is incorrect !", "Désolé, nous n'avons pas pu trouver votre compte. Username est incorrect!"),
    ACCOUNT_USER_NOT_FOUND_ID(ERR_AU_0002, "Sorry, we could not find your account.", "Désolé, nous n'avons pas pu trouver votre compte."),
    ACCOUNT_USER_FAILED_AUTHENTICATION(ERR_AU_0003, "Sorry, we could not find your account. Username or password is incorrect", "Désolé, nous n'avons pas pu trouver votre compte. Le username ou le mot de passe est incorrect"),
    ACCOUNT_USER_NAME_EXISTS(ERR_AU_0004, "This username is already associated with another account !", "Ce username est déjà associé à un autre compte !"),
    ACCOUNT_USER_LOCKED(ERR_AU_0005, "Account User locked for 1 minute !", "Ce compte est bloqué pour 1 minute !"),
    ACCOUNT_USER_COULD_NOT_BE_DELETED(ERR_AU_0006, "This account coudn't be deleted" , "Cet utilisateur est admin pour d'autre utilisateurs, vous pouvez pas le supprimer "),
    FAILED_ACCESS_TOKEN(ERR_AU_0007,"User or client token invalid","Le token d'utilisateur ou du client n'est pas valid"),
    ACCOUNT_USER_OLD_PASSWORD_INCORRECT(ERR_AU_0008, "User old password is incorrect !", "Ancien mot de passe incorrect !"),
    ACCOUNT_USER_OLD_PASSWORD_MISSING(ERR_AU_0009, "Your old password is required to update your password !", "Votre ancien mot de passe est nécessaire pour mettre à jour votre mot de passe !"),
    ACCOUNT_USER_MISSING_INFORMATION(ERR_AU_0010, "To initialize a transaction please fill in the required informations(Phone number,...) in the profile section!",
            "Pour initialiser une transaction, veuillez remplir les informations requises (numéro de téléphone,...) dans la section profil!"),
    ACCOUNT_USER_SUBSCRIPTION_EXPIRED(ERR_AU_0011, "User subscription expired !", "Forfait Utilisateur expirée !"),
    ACCOUNT_USER_MAIL_NOT_VERIFIED(ERR_AU_0012, "Account User e-mail is not verified !", "Email d'utilisateur n'est pas vérifié !"),
    ACCOUNT_USER_MAIL_ALREADY_VERIFIED(ERR_AU_0013, "Account User e-mail is already verified !", "Email d'utilisateur est déjà vérifié !"),
    ACCOUNT_USER_MAIL_VERIFICATION_RESEND_EXCEEDED(ERR_AU_0014, "Account User exceeded number of allowed verification mail resends !", "Compte Utilisateur a dépassé le nombre autorisé des renvois de mail de validation !"),
    ACCOUNT_USER_GOOGLE_RESPONSE_ERROR(ERR_AU_0015 , "Can't validate captcha code", "Impossible de valider le code captcha"),
    ACCOUNT_USER_CAPTCHA_MAXIMUM_ATTEMPTS(ERR_AU_0016 , "You have exceeded the maximum number of failed captcha attempts", "Vous avez dépassé le nombre maximal d'échecs de tentatives de captcha"),
    ACCOUNT_USER_PASSWORD_RESET_RESEND_EXCEEDED(ERR_AU_0017 , "Account User exceeded number of allowed password reset mail resends !", "L'utilisateur du compte a dépassé le nombre d'envois de messages de réinitialisation de mot de passe autorisés !"),
    ACCOUNT_USER_PASSWORD_RESET_TOKEN_INVALID(ERR_AU_0018 , "Validation token is invalid, expired or email invalid !", "Le jeton de validation n'est pas valide, a expiré ou l'email n'est pas valide !"),
    ACCOUNT_USER_RESET_OLD_PASSWORD_MATCH(ERR_AU_0019 , "New password cannot be the same as old password !", "Le nouveau mot de passe ne peut pas être le même que l'ancien !"),
    FAILED_ACCOUNT_USER_EDIT(ERR_AU_0020,"Unauthorized to edit this user profile","Vous avez pas le droit de modifier ce compte utilisateur !") ,
    ACCOUNT_USER_NEW_PASSWORD_MISSING(ERR_AU_0021 , "Your new password is required to update your password !", "Votre nouveau mot de passe est nécessaire pour mettre à jour votre mot de passe !" ),
    USER_ACCOUNT_NOT_ACTIVE(ERR_AU_0022 , "User account not active" , "Votre compte utilisateur est désactiv&!"),
    ACCOUNT_USER_NOT_ACCESSIBLE(ERR_AU_0023 , "You don't have authority to alter this user, this user is created by another admin !" , "Cet utilisateur est créé par un autre admin, vous avez aucune autorization sur cet utilisateur !"),
    // Certification Authority error codes
    CERTIFICATION_AUTHORITY_NOT_FOUND_ID(ERR_CA_0001, "Certification Authority ID not found !", "ID d'Autorité de Certification Introuvable !"),
    CERTIFICATION_AUTHORITY_NOT_FOUND_CODE(ERR_CA_0002, "Certification Authority Code not found !", "Code d'Autorité de Certification Introuvable !"),
    CERTIFICATION_AUTHORITY_NOT_FOUND_ACTIVE(ERR_CA_0003, "Active Certification Authority not found !", "Aucune Autorité de Certification n'est Active !"),
    // Endpoint error codes
    ENDPOINT_NOT_FOUND_ID(ERR_EP_0001, "Endpoint ID not found !", "ID Endpoint Introuvable !"),
    ENDPOINT_NOT_FOUND_CODE(ERR_EP_0002, "Endpoint Code not found !", "Code Endpoint Introuvable !"),
    ENDPOINT_DATA_INVALID(ERR_EP_0003, "Endpoint data is invalid !", "Données Endpoint sont invalides !"),

    // Document error codes
    DOCUMENT_NOT_FOUND_ID(ERR_DC_0001, "Document ID not found !", "ID Document Introuvable !"),
    DOCUMENT_SIGNATURE_PAGE_ERROR(ERR_DC_0002, "Page parameter needs to be less or equal than the number of pages !", "Page de Signature doit être inférieur ou égal au nombre des Pages !"),
    DOCUMENT_PAGE_NUMBER_EXCEED_DOCUMENT(ERR_DC_0003, "This page doesn't exist on this document !", "Cette page n'existe pas dans ce document!"),
    DOCUMENT_SIGNATURE_ERROR(ERR_DC_0004, "Document signature has failed due to unexpected error !", "Signature du document a échouée dû à une erreur survenue !"),
    DOCUMENT_MIMETYPE_ERROR(ERR_DC_0005, "Unsupported file type !", "Le type de fichier non pris en charge !"),


    // Evidence Record error codes
    EVIDENCE_RECORD_FAILED_DATA(ERR_ER_0001, "Evidence record data generation failed !", "Génération des données du dossier de preuve a échoué !"),
    EVIDENCE_RECORD_FAILED_SEAL(ERR_ER_0002, "Evidence record seal failed !", "Cachetage de dossier de preuve a échoué !"),
    EVIDENCE_RECORD_FAILED_CONVERSION(ERR_ER_0003, "Evidence record PDF/A conversion failed !", "Conversion du dossier de preuve en PDF/A a échoué !"),
    EVIDENCE_RECORD_NOT_GENERATED(ERR_ER_0004, "Evidence record is not generated !", "Dossier de preuve n'est pas généré !"),

    // Evidence File error codes
    EVIDENCE_FILE_NOT_FOUND(ERR_EF_0001, "Evidence file not found !", "Fichier de preuve introuvable !"),
    EVIDENCE_FILE_DATA_MISSING(ERR_EF_0001, "Evidence files data are missing !", "Les données des fichiers de preuve sont manquantes !"),
    EVIDENCE_FILE_DATA_MISMATCH(ERR_EF_0003, "Mismatch in number of evidence files and their types !", "Non conformité des nombres de fichiers de preuve et leurs types !"),

    // KeyStore error codes
    KEYSTORE_NOT_FOUND_ACTIVE_TRANSACTION(ERR_KS_0001, "Active KeyStore for transaction not found !", "Transaction n'a pas de keyStore actif !"),
    KEYSTORE_NOT_FOUND_CERTIFICATE_TRANSACTION(ERR_KS_0002, "KeyStore Certificate for transaction not found !", "Transaction n'a pas de certificat !"),
    KEYSTORE_EXPIRED_CERTIFICATE(ERR_KS_0003, "KeyStore certificate is already expired !", "Certificat est déjà expirée !"),

    // Directory error codes
    DIRECTORY_NOT_FOUND_CONTENT_TYPE(ERR_DR_0001, "Directory Content Type not found !", "Type de Contenu Répertoire Introuvable !"),
    DIRECTORY_NOT_FOUND_FULL_PATH(ERR_DR_0002,"No directory found ","Répertoire Introuvable!"),

    // Screenshot error codes
    SCREENSHOT_NOT_FOUND_ID(ERR_SS_0001, "Screenshot not found !", "Screenshot introuvable !"),

    // StatusHistory error codes
    STATUS_HISTORY_NOT_FOUND_ID(ERR_SH_0001, "Status history not found !", "Historique du statut introuvable !"),

    // ADTConst error codes
    ADT_CONST_NOT_FOUND_ID(ERR_AD_0001, "ADT Const not found !", "ADT Const introuvable !"),
    ADT_CONST_NOT_FOUND_CODE(ERR_AD_0002, "ADT Const not found !", "ADT Const introuvable !"),

    // Format error codes
    FORMAT_DIGEST_ALGORITHM_NOT_FOUND_CODE(ERR_FM_0001, "Format Digest Algorithm Code not found !", "Code Format d'Algorithme de Hachage Introuvable !"),
    FORMAT_SIGNATURE_NOT_FOUND_CODE(ERR_FM_0002, "Format Signature Code not found !", "Code Format de Signature Introuvable !"),

    // Logging error codes
    LOGGING_FAILED(ERR_LG_0001, "Logging error occurred !", "Erreur est Survenue lors d'Enregistrement des Logs !"),
    LOGOUT_FAILED(ERR_LG_0002, "Logout error occurred !", "Erreur est Survenue lors de déconnecter !"),

    // Terms Of Use error codes
    TERMS_OF_USE_NOT_FOUND(ERR_TU_0001, "Terms of use not found !", "Conditions d'utilisations Introuvable !"),

    // TSP Authorities error codes
    TSP_AUTHORITY_JKS_SECRET_MISSING(ERR_TSP_0001, "TSP Authority keystore file's secret is missing !", "Le secret du KeyStore de l'Autorité d'horodatage est manquant !"),
    TSP_AUTHORITY_NOT_FOUND_ID(ERR_TSP_0002, "TSP Authority ID not found !", "Autorité d'horodatage introuvable !"),
    TSP_AUTHORITY_LABEL_EXISTS(ERR_TSP_0003, "TSP Authority label already exists !", "Libellé de l'autorité d'horodate existe déjà !"),
    TSP_AUTHORITY_JKS_FILE_MISSING(ERR_TSP_0004, "TSP Authority keystore file is mising !", "Le KeyStore de l'Autorité d'horodatage est manquant !"),
    TSP_AUTHORITY_JKS_SECRET_INVALID(ERR_TSP_0005, "TSP Authority KeyStore file secret is invalid !", "Le secret du keystore de l'autorité d'horodatage est invalide !"),

    // Generic File error codes
    FILE_NOT_FOUND(ERR_FL_0001, "File not found !", "Fichier Introuvable !"),
    FILE_FAILED_SAVE(ERR_FL_0002, "File storage failed !", "Enregistrement du Fichier a échoué !"),
    FILE_FAILED_DELETE(ERR_FL_0003, "Files deletion failed !", "Suppression des Fichiers a échoué !"),
    FILE_FAILED_EXISTS(ERR_FL_0004, "File already exists !", "Fichier Existe Déjà !"),
    FILE_FAILED_EMPTY(ERR_FL_0005, "File is empty !", "Fichier est Vide !"),
    FILE_FAILED_INVALID(ERR_FL_0006, "File data is invalid or corrupted !", "Fichier a des données Invalides ou Corrompues !"),
    FILE_FAILED_SIZE(ERR_FL_0007, "File size exceeds the allowed limit !", "Taille du fichier dépasse la limite autorisée !"),
    FILE_FAILED_ENCRYPTED(ERR_FL_0008, "File is password protected !", "Fichier est protégé par un mot de passe !"),


    // Configuration error codes
    CONFIGURATION_FAILED_ESIGN_KEYSTORE(ERR_CF_0001, "Couldn't load Barid eSign jks KeyStore !", "Impossible de charger fichier jks de Barid eSign !"),
    CONFIGURATION_FAILED_ESIGN_SSL(ERR_CF_0002, "Barid eSign SSL configuration error !", "Erreur de Configuration SSL de Barid eSign !"),
    CONFIGURATION_FAILED_PDF_VALIDATOR(ERR_CF_0003, "Context is only null while testing !", "Context est null !"),

    // Keycloak error codes
    KEYCLOAK_NOT_FOUND_USER(ERR_KY_0001, "User not found !", "Utilisateur Introuvable !"),
    KEYCLOAK_EXPIRED_SUBSCRIPTION(ERR_KY_0002, "User subscription expired !", "Forfait Utilisateur expirée !"),
    KEYCLOAK_FAILED_ACCESS_TOKEN(ERR_KY_0003, "Couldn't get the Access token from Keycloak Server !", "Impossible de récupérer Access Token depuis le Serveur Keycloak !"),
    KEYCLOAK_FAILED_CLIENT_CREATION(ERR_KY_0004, "Couldn't Create Client in Keycloak Server !", "Impossible de créer le Client dans le Serveur Keycloak !"),
    KEYCLOAK_FAILED_CLIENT_UPDATE(ERR_KY_0005, "Couldn't Update Client in Keycloak Server!", "Impossible de modifier le Client dans le Serveur Keycloak !"),
    KEYCLOAK_FAILED_CLIENT_SECRET(ERR_KY_0006, "Couldn't get Client Secret from Keycloak Server !", "Impossible de récupérer le Secret du Client depuis le Serveur Keycloak !"),
    KEYCLOAK_FAILED_CLIENT_DELETE(ERR_KY_0007, "Couldn't delete Client from Keycloak Server !", "Impossible de supprimer le Client depuis le Serveur Keycloak !"),
    KEYCLOAK_FAILED_ACCOUNT_USER_CREATION(ERR_KY_0008, "Couldn't Create User in Keycloak Server !", "Impossible de créer l'Utilisateur dans le Serveur Keycloak !"),
    KEYCLOAK_FAILED_ACCOUNT_USER_ROLE_ASSIGN(ERR_KY_0009, "Couldn't Assign Roles to User in Keycloak Server !", "Impossible d'assigner les rôles à l'Utilisateur dans le Serveur Keycloak !"),
    KEYCLOAK_FAILED_ACCOUNT_USER_UPDATE(ERR_KY_0010,"Couldn't Update the user in Keycloak Server!","Impossible de modifier l'utilisateur dans le Serveur Keycloak !"),
    KEYCLOAK_FAILED_ACCOUNT_USER_DELETE(ERR_KY_0011,"Couldn't Update the user in Keycloak Server!","Impossible de supprimer l'utilisateur dans le Serveur Keycloak !"),
    ACCESS_TOKEN_NOT_VALID(ERR_KY_0012,"Access token not valid","Le token n'est pas valid"),
    TOKEN_CLIENT_ID_NOT_FOUND(ERR_KY_0013,"Client id not fount in the access token","Le client id n'a pas été trouvé dans le token"),
    ACCESS_TOKEN_PARSE_FAILED(ERR_KY_0014,"Error during the parse of the access token","Erreur durant le décodage du token"),
    CLIENT_ACCESS_TOKEN_NOT_VALID(ERR_KY_0015,"Client access token not valid","Le token du cient n'est pas valid"),
    REFRESH_TOKEN_NOT_VALID(ERR_KY_0016 , "Token is not active" , "Le token n'est pas activé !"),
    // KYC error codes
    KYC_FAILED_ACCESS_TOKEN(ERR_KYC_0001, "Couldn't get the Access token from KYC server !", "Impossible de récupérer Access Token depuis le Serveur KYC !"),
    KYC_INVALID_PROVIDER(ERR_KYC_0002, "Couldn't get the client application's KYC provider !", "Impossible d'obtenir le fournisseur KYC de l'application client !"),
    KYC_MISSING_PROVIDER_CONFIGURATIONS(ERR_KYC_0003, "Missing KYC provider configurations !", "Des configurations de fournisseurs KYC manquantes !"),
    KYC_SESSION_FAILED(ERR_KYC_0004, "KYC Session error occurred !", "Une erreur est survenue lors de la session KYC !"),
    KYC_SESSION_NOT_FOUND(ERR_KYC_0005, "Transaction has no KYC Session !", "Transaction n'a aucune session de KYC !"),
    KYC_SESSION_ALREADY_EXISTS(ERR_KYC_0006, "KYC Session already exists and active !", "La session KYC existe déjà et est active !"),
    KYC_EXTERNAL_SERVICE_ERROR(ERR_KYC_0007, "Unexpected error occurred while Communicating with External Service !", "Une erreur est survenue lors de la communication avec un service externe !"),
    KYC_SESSION_MATCHING_FAILED(ERR_KYC_0008, "Signatory Data does not match KYC Session verified data !", "Les données du signataire ne sont pas compatibles avec les données vérifiées par session KYC !"),
    KYC_SESSION_UNAUTHORIZED_PROVIDER(ERR_KYC_0009, "This operation is unauthorized for current KYC Provider !", "Cette opération est non autorisé pour le fournisseur KYC configuré !"),
    KYC_SESSION_EXPIRED(ERR_KYC_0010, "KYC Session expired !", "La session KYC a expiré !"),
    KYC_SESSION_INACCESSIBLE(ERR_KYC_0011, "KYC Session is no longer accessible !", "Session KYC n'est plus accessible !"),
    KYC_SESSION_NON_RESETTABLE(ERR_KYC_0012, "KYC Session cannot be reset !", "Session KYC ne peut pas être réinitialisée !"),
    KYC_CLIENT_TOKEN_PARSE_FAILED(ERR_KYC_0013,"Couldn't parse the client token","Impossible do decoder de token client "),

    // KYC Configuration errors
    SCOPE_CONFIGURATION_NOT_FOUND(ERR_KYCC_0001, "Scope configuration not found !", "Configuration du scope non trouvée !"),
    SCOPE_CONFIGURATION_DATA_INVALID(ERR_KYCC_0002, "Scope configuration data is invalid !", "Données du scope sont invalides !"),
    KYC_CONFIGURATION_NOT_FOUND(ERR_KYCC_0003, "KYC configuration not found !", "Configuration du KYC non trouvée !"),

    // Theme errors
    LINEAR_GRADIENT_STOP_NOT_FOUND(ERR_THEME_0001, "Stop's color not found !", "Arrêt de couleur non trouvée !"),
    THEME_NOT_FOUND(ERR_THEME_0002, "Theme not found !", "Thème non trouvée !"),

    // System errors
    SYSTEM_SPRING_EXCEPTION(ERR_SY_0001, Constants.DEFAULT_GENERIC_ENG_MESSAGE, Constants.DEFAULT_GENERIC_FR_MESSAGE),
    SYSTEM_PAYLOAD_TOO_LARGE(ERR_SY_0002, "Maximal Upload Size Exceeded !", "La taille maximale du téléchargement est dépassée !"),
    SYSTEM_PARSE_ERROR(ERR_SY_0003, "Unexpected error occurred while parsing data !", "Une erreur est survenue lors la conversion des données !"),
    SYSTEM_EXTERNAL_SERVICE_ERROR(ERR_SY_0004, "Unexpected error occurred while Communicating with External Service !", "Une erreur est survenue lors de la communication avec un service externe !"),
    SYSTEM_INTERNAL_ERROR(ERR_SY_0005, "Couldn't get the Server IP", "Impossible de récupérer l'adresse IP du Serveur !"),
    SYSTEM_ENCRYPTION_ERROR(ERR_SY_0007, "Secret Encryption failed !", "Cryptage du secret a échoué !"),
    SYSTEM_DECRYPTION_ERROR(ERR_SY_0008, "Secret Decryption failed !", "Décryptage du secret a échoué !"),
    // Internal errors
    GENERIC_ERROR(ERR_GN_0000, Constants.DEFAULT_GENERIC_ENG_MESSAGE, Constants.DEFAULT_GENERIC_FR_MESSAGE);

    /**
     * <p>Default english Error Message value</p>
     */
    private final DetailedErrorCode detailedErrorCode;

    /**
     * <p>Default english Error Message value</p>
     */
    private final String engMessage;

    /**
     * <p>Default french Error Message value</p>
     */
    private final String frMessage;

    ErrorCode(DetailedErrorCode detailedErrorCode, String engMessage, String frMessage) {
        this.detailedErrorCode = detailedErrorCode;
        this.engMessage = engMessage;
        this.frMessage = frMessage;
    }


    /**
     * <p>Constants static block that holds generic error messages that are used in multiple error codes</p>
     */
    private static class Constants {

        private static final String DEFAULT_GENERIC_ENG_MESSAGE = "Unexpected error occurred, please try again later !";

        private static final String DEFAULT_GENERIC_FR_MESSAGE = "Une erreur inattendue s'est produite, veuillez réessayer plus tard !";

    }

}
