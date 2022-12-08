clear variables;
close all;
clc;

%% Synthése du bruit %%
T = 100;
t = 0:1:T;

Xp = struct('sigma', sqrt(5), 'Fs',500, 'B', 160,'T', 100) ;

figure(1);
[X, Xp] = CGN(Xp);
var(X.data)
mean(X.data)

P = (trapz(X.time,X.data.^2)/T)
%P=2.Gamma0.Bande-passante
G_0 =P/(2*160) 

%% Filtre passe bande %%

figure(2);
Fp = struct('Fs', 500, 'F0', 100, 'Dnu', 16,'order', 6, 'class', 'BP filter') ;

[Y,Fp] = BPF(X,Fp);

Puissance = (trapz(Y.time,Y.data.^2)/T)
Gamma_0 = Puissance/(2*16)

%% Elevation au carré

Z = SquareSig(X);
k=3;
moy = zeros(1,3);
v = zeros(1,3);
kurt = zeros(1,3);
moy_corr = zeros(1,3);
v_corr = zeros(1,3);
kurt_corr = zeros(1,3);
Fs = 500;

figure(3);
%RC = [1/8, 5/4, 25/4]
for RC = [1/8, 5/4, 25/4] % k = 1:3
    correction = 5*RC*Fs;
    figure(k);
    RCFp = struct('Fs', Fs, 'RC', RC);
    [W,RCFp] = RCF (Z,RCFp);
    disp(k);
    moy(k-2) = mean(W.data);
    v(k-2) = var(W.data);
    kurt(k-2) = kurtosis(W.data);
    W_corr = W.data(:,correction:end);
    moy_corr(k-2) = mean(W_corr);
    v_corr(k-2) = var(W_corr);
    kurt_corr(k-2) = kurtosis(W_corr);
    k = k + 1;
    
end

disp(moy);
disp(v);
disp(kurt);
disp(moy_corr);
disp(v_corr);
disp(kurt_corr);

##%% Signal + Bruit
##figure(1);
##Fc = 100;
##Sp = struct('Fs',Fs,'A',1,'Fc',Fc,'FM',0,'Phi',0,'T',T,'W',[])
##
##[S,Sp,M] = OOK(Sp);
##figure(2)
##Sp_filtre = struct('sigma', sqrt(5), 'Fs', Fs, 'B', 16, "T", 100);
##
##figure(4);
##[S_filtre, Sp_filtre] = BPF(S,Sp_filtre);
##
##figure(5);
##Bp = struct('Fs',Fs,'A',1,'Fc',Fc,'FM',0,'Phi',0,'T', T,'W',[])
##
##[B,Bp] = CGN(Xp);
##ADD = AddSig(X, S);
##
##RCFp_add = struct('Fs',Fs,'RC',5/4)
##
##[W_SB,RCFp_add] = RCF (ADD,RCFp_add)
##
##
##%% Transmission d'un message binaire %%
##T = 100;
##
##Xp = struct("sigma", sqrt(5), "Fs", 1000, "B", 400, "T", T);
##[B, Xp] = CGN(Xp);







