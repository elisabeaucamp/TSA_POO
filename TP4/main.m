clear variables;
close all;
clc;

%% Signal et contexte %%

[s,Fs]= audioread('ProtestMonoBruit.wav');
t = (1:1:length(s))/Fs;

##plot(t, s);
##xlabel('Temps(s)');
##ylabel('Signal s');
##title('Signal Protest avec craquements');

##%sound(s, Fs);

%% Estimation de la fonction d'autocorelation %%
t2 = t(60*Fs:70*Fs);
s2 = s(60*Fs:70*Fs);

K = 200;
[R, lags] = xcorr(s2, K, 'biased');
##figure(2);
##stem(lags, R);
##xlabel('Vecteurs des correlations');
##ylabel('Vecteurs des retards');
##title("Signal d'autocorrelation");

%% Identification du modÃ¨le %%
M = 20;
%k = 1:1:M+1;
G = toeplitz(R(201:201+M));

b = zeros(M+1,1);
b(1) = b(1) + 1;

G_inv = pinv(G);

phi = G_inv*b;

var = 1/phi(1);
h = -phi(2:end)*var;

##figure(3);
##stem(h);
##xlabel('Coefficients du modèle AR(M)');
##ylabel('Amplitude');
##title('Réponse indicielle');

%% PrÃ©diction linÃ©aire %%
s_tild = conv(h, s2);
erreur = abs(s_tild(M:end) - s2);
##
##figure(4);
##
##subplot(211);
##plot(t2, s2);
##
##xlabel('Temps (s)');
##ylabel("Signal d'origine et predit");
##title('Prediction du signal sur [60;70]');
##
##hold on;
##plot(t2, s_tild(M:end)); 
##legend("Signal d'origine",'Prediction du signal');
##
##subplot(212);
##plot(t2, erreur);
##xlabel('Temps (s)');
##ylabel('Amplitude');
##title('Valeur absolue de la prediction');

%% Resteauration par seuillage %%
seuil = 0.13;
s_rest = zeros(1,length(s2));
j = 1 ;
for j = 1:length(s2)
  if erreur(j)>seuil
    s_rest(j) = median(s2(j-10:j+10));
  else
    s_rest(j) = s2(j);
  end
end

figure(5)
plot(t2,s2);
hold on;
plot(t2,s_rest);
legend("Signal d'origine",'Signal restaure');
xlabel('Temps (s)');
ylabel('Signaux');
title('Signal restaure');

%sound(s_rest,Fs)

##
##%% Causalité %%
##
##scausal = zeros(length(s2),1);
##santicausal = zeros(length(s2),1);
##
##scausal(1:(M-1)) = s2(1:(M-1));
##
##for j = (M+1):1:length(s2)
##  scausal(j)= sum(h(1:length(h)).*s2((j-M:j-1)));
##end
##
##erreurcausale = abs(scausal - s2);
##
##%% Anticausalité %%
##
##santicausal(length(s2) - M + 1:length(s2)) = s2(length(s2) - M + 1:length(s2));
##
##for j = length(s2)-(M+1):-1:1
##  santicausal(j) = sum(h(1:length(h)).*s2((j+1:j+M)));
##end
##
##erreuranticausale = abs(santicausal - s2);
##
##%% Restauration par prédiction causale %%
##
##stotal = zeros(1,length(s2));
##
##for j = 1:length(s2)
##  if erreurcausale(j) > seuil && erreuranticausale(j) > seuil
##    stotal(j) = (scausal(j) + santicausal(j))/2;
##  else
##    stotal(j) = s2(j);
##  end
##end
##
##figure(6);
##plot(t2,stotal);
##hold on;
##plot(t2,s2);
##
##xlabel('Temps (s)');
##ylabel('Signal');
##title('Signal restaure grace a la causalite et anticausalite');
##legend('Signal restaure',"Signal d'origine");
##
##%sound(stotal,Fs)










