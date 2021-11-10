# Instalando o eksctl e o kubectl

https://github.com/weaveworks/eksctl

Links úteis:

https://github.com/weaveworks/eksctl
https://scoop.sh/
https://kubernetes.io/docs/tasks/tools/install-kubectl-windows/#install-on-windows-using-chocolatey-or-scoop
https://docs.microsoft.com/en-us/powershell/module/microsoft.powershell.management/new-item?view=powershell-7.1


- Windows 

	- Utilizar o scoop (A command-line installer for Windows) use o PowerShell para instalação.
	
	Execute -> Invoke-Expression (New-Object System.Net.WebClient).DownloadString('https://get.scoop.sh')
	
	- Em caso de erro no PowerShell: "PowerShell requires an execution policy in [Unrestricted, RemoteSigned, ByPass] to run Scoop."
	
	Execute -> Set-ExecutionPolicy RemoteSigned -scope CurrentUser
	
	- E apos execute novamente o primeiro passo
	
	OBS: Permita a execução apenas para este script para proteção contra script malicíosos. Opção [S]
	
	Após instalação com sucesso será possível observar a saida algo similar como:
	
	Initializing...
	Downloading scoop...
	Extracting...
	Creating shim...
	Downloading main bucket...
	Extracting...
	Adding ~\scoop\shims to your path.
	'lastupdate' has been set to '2021-07-03T19:16:15.3206914-03:00'
	Scoop was installed successfully!
	Type 'scoop help' for instructions.
	
	- Verifique se a instalação foi realizada com sucesso
	
	Execute -> scoop help
	
- Siga com a instalação do eksctl
	
	Execute	no prompt do windows (CMD ou PowerShell) -> scoop install eksctl
	
	Após instalação com sucesso será possível observar a saida algo como:

	Installing 'eksctl' (0.55.0) [64bit]
	eksctl_Windows_amd64.zip (17,8 MB) [==========================================================================================================================] 100%
	Checking hash of eksctl_Windows_amd64.zip ... ok.
	Extracting eksctl_Windows_amd64.zip ... done.
	Linking ~\scoop\apps\eksctl\current => ~\scoop\apps\eksctl\0.55.0
	Creating shim for 'eksctl'.
	'eksctl' (0.55.0) was installed successfully!
	
- Siga com a instalação do kubectl
	
	Execute -> scoop install kubectl
	
	Após instalação com sucesso será possível observar a saida algo como:
	
	Installing '7zip' (19.00) [64bit]
	7z1900-x64.msi (1,7 MB) [=====================================================================================================================================] 100%
	Checking hash of 7z1900-x64.msi ... ok.
	Extracting 7z1900-x64.msi ... done.
	Linking ~\scoop\apps\7zip\current => ~\scoop\apps\7zip\19.00
	Creating shim for '7z'.
	Creating shortcut for 7-Zip (7zFM.exe)
	'7zip' (19.00) was installed successfully!
	Installing 'kubectl' (1.21.2) [64bit]
	kubernetes-client-windows-amd64.tar.gz (24,8 MB) [============================================================================================================] 100%
	Checking hash of kubernetes-client-windows-amd64.tar.gz ... ok.
	Extracting kubernetes-client-windows-amd64.tar.gz ... done.
	Linking ~\scoop\apps\kubectl\current => ~\scoop\apps\kubectl\1.21.2
	Creating shim for 'kubectl'.
	'kubectl' (1.21.2) was installed successfully!
	
- Verifique se a instalação foi realizada com sucesso
	
	Execute -> kubectl version --client
	
	Após instalação com sucesso será possível observar a saida algo como:
	
	Client Version: version.Info{Major:"1", Minor:"21", GitVersion:"v1.21.2", GitCommit:"092fbfbf53427de67cac1e9fa54aaa09a28371d7", GitTreeState:"clean", 
	BuildDate:"2021-06-16T12:59:11Z", GoVersion:"go1.16.5", Compiler:"gc", Platform:"windows/amd64"}
	
	- Navegue até a pasta do usuário crie o diretório .kube
	
	Execute -> mkdir .kube
	Execute -> cd .kube
	
	- Utilizando o PowerShell crie um Novo Item [File] - para saber mais pesquise a documentação
	
	Execute -> New-Item config -type file
	
	- Ou crie um arquivo vazio config na pasta .kube
	
# Criação do cluster utilizando o eksctl

eksctl.exe create cluster --name <nome-do-cluster>


#####

Comandos e Argumentos no Kubernetes

Assim como no Docker é possivel passar comandos e argumentos no K8s para a imagem

# Dockerfile

FROM ubuntu

ENTRYPOINT ["sleep"]

CMD ["5"]


# pod-definition.yaml

apiVersion: v1
kind: Pod
metadata:
  name: ubuntu-sleeper-pod
spec:
  containers:
    - name: ubuntu-sleeper
      image: ubuntu-sleeper
	  command: ["sleep2.0"] # substitui o comando no ENTRYPOINT
	  args: ["10"] # valor do argumento a ser passado para o container ao ser iniciado