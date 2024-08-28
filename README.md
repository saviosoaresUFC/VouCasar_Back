<h1 align="center">Vou Casar</h1>

<h2 align="center">Este é o repositório da aplicação backend do projeto <strong>Vou Casar</strong> desenvolvido em Spring pela equipe da CarvalhoTech Solutions</h2>

## 🚀 Execução

1. Faça um clone desse repositório rodando: <br> `git clone https://github.com/saviosoaresUFC/VouCasar_Back.git`;
2. Entre na pasta criada;
---

## 🤔 Padrões de contribuição

* Se certifique de que você está na versão mais recente da branch *main* do repositório.

```text
git pull origin main
```

* Faça o checkout da branch de desenvolvimento usando o comando git

```text
git checkout main 
```

* Crie uma nova branch para a sua tarefa com o comando

```text
git checkout -b nome-da-branch
```

Onde "nome-da-branch" deve seguir o padrão "VOU-24-[número da task com 3 digitos] - [tipo de task] - [descrição-curta]".

| tipo de task | palavra-chave |
| ------------ | :-----------: |
| nova funcionalidade |     feature     |
| correção de bugs |     fix      |
| refatoração |     refac      |

Exemplo:
```text
git checkout -b VOU-24-001-feature-login
```

* Faça as alterações no código necessárias para completar a task e faça commits com mensagens descritivas e claras.

| tipo de commit   | palavra-chave |
| ---------------- | :-----------: |
| commit inicial   |     init      |
| novo recurso     |     feat      |
| teste            |     test      |
| correção de bugs |      fix      |
| refatoração      |     refac     |

Exemplo:
```text
git commit -m "feat: implementar login"
```

* Preferencialmente cada branch deve conter apenas um commit com todas as alterações necessárias para completar a task. Caso seja necessário fazer mais de um commit, faça commits atômicos, ou seja, cada commit deve conter alterações que façam sentido por si só.

## 😅 Terminei de implementar a task. E agora?

*  Quando a task estiver completa e testada, faça um push da sua branch para o repositório remoto.

```text
git push origin nome-da-branch
```

* Faça o rebase da sua branch com a branch *main* para garantir que ela está atualizada com as últimas alterações feitas na branch *main*.

```text
git fetch --all
git rebase origin/main
```

* Resolva os conflitos que possam surgir durante o rebase. Se você não souber como resolver os conflitos, peça ajuda a um membro da equipe.

* Faça um push da sua branch atualizada para o repositório remoto.

```text
git push origin nome-da-branch -f
```

* Abra um pull request (PR) da branch criada para a branch *main*. Para isso entre no repositório do github e navegue até o menu *Pull Requests*. Clique em *New Pull Request* e selecione a branch que você criou e a branch *main*.

* Preencha os campos do PR com informações claras e objetivas sobre a task.

* Adicione o membro que deve revisar o código como *assignees*.

* Adicione as labels *fix*, *feature* ou *refac* de acordo com o tipo de commit que você fez.

* Avise os membros da equipe que você abriu um PR para que eles possam revisar o código.

* Aguarde a aprovação e, se necessário, faça as alterações sugeridas.
---

### Lembre-se de seguir essas práticas cada vez que trabalhar em uma nova task. Isso ajudará a manter o código organizado e fácil de entender, além de facilitar a revisão e aprovação de código pelos membros da equipe. Se você tiver alguma dúvida, não hesite em perguntar aos seus colegas de equipe.
