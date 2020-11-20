
ALTER proc [dbo].sp_updateCliente(    
     
	 @Name nvarchar(200),  
	 @cpf nchar(28),  
	 @telefone nchar(40),  
	 @email nvarchar(200),  
	 @dataNascimento datetime,  
	 @address nvarchar(400),  
	 @formacao nvarchar(200),  
	 @profissao nvarchar(100),  
	 @renda nvarchar(200)) as     
     
    
begin  

 --Verifica se registro existe na tabela cliente
	if not exists (select * from tblCliente where CPF = @cpf)
	begin
		print 'Registro inexistente'
		return -1
	end
 --desabilita contagem de registros    
 set nocount on    
 update tblCliente set Nome = upper(@Name), Telefone = rtrim(@telefone), Email = upper(@email), DataNascimento = @dataNascimento, Endereco = upper(@address),
 Formacao = upper(@formacao), Profissao = upper(@profissao), Renda = rtrim(@renda)
 where CPF = @cpf
 --verifica se ocorreu algum erro    
 if @@ERROR <> 0     
  return -1    
 else    
  return 0    
 --habilita contagem de registros    
 set nocount off    
    
end  


-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------

ALTER proc sp_updateEmprestimos(  
  
 @id int, 
 @dataSolicitacao datetime,  
 @taxaJuros nchar(20),  
 @prazoPagamento datetime,  
 @valorTotal money,  
 @QuantParcelas int,  
 @valorParcelas money,  
 @Situacao nvarchar(200)) as  
   
  
begin  

--Verifica se registro existe na tabela emprestimos
	if not exists (select * from tblEmprestimos where idEmprestimo = @id)
	begin
		print 'Registro inexistente'
		return -1
	end
 --desabilita contagem de registros  
 set nocount on  
 update tblEmprestimos   
  set DataSolicitacao = @dataSolicitacao, TaxaJuros = @taxaJuros, PrazoPagamento = @prazoPagamento, ValorTotal = @valorTotal, QuantParcelas = @QuantParcelas, 
  ValorParcelas = @valorParcelas, Situacao = upper(@Situacao)
  where idEmprestimo = @id
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------
ALTER proc [dbo].[sp_updateCartao](    
     
 @NumCartao nchar(28),          
 @tipo nvarchar(40),    
 @Moeda nvarchar(40),    
 @Saldo money,    
 @flag nvarchar(100), -- Bloqueado: 0 / Desbloqueado: 1  / Bloqueio Definitivo: 2  
 @limTotal float,  
 @limUsado float,  
 @MotBloqueio nvarchar(160),  
 @cvv nvarchar(40),  
 @dataValidade datetime) as    
     
    
begin    
	--Verifica se registro existe na tabela cartao
	if not exists (select * from tblCartao where NumCartao = @NumCartao)
	begin
		print 'Registro inexistente'
		return -1
	end
 --desabilita contagem de registros    
 set nocount on    
 update tblCartao     
  set Tipo=upper(@tipo), Moeda=upper(@Moeda), Saldo=@Saldo, flagBloqueado=upper(@flag), LimiteTotal=@limTotal, LimiteUsado=@limUsado, MotivoBloqueio=upper(@MotBloqueio), 
  cvv=rtrim(@cvv), dataValidade=@dataValidade  
  where NumCartao = @NumCartao
 --verifica se ocorreu algum erro    
 if @@ERROR <> 0     
  return -1    
 else    
  return 0    
 --habilita contagem de registros    
 set nocount off    
    
end  

-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------


create proc sp_updateConta(  
   
 @NumConta nchar(20),   
 @Saldo money,    
 @Senha nvarchar(20)) as  
   
  
begin  
	--Verifica se registro existe na tabela conta
	if not exists (select * from tblConta where NumConta = @NumConta)
	begin
		print 'Registro inexistente'
		return -1
	end
 --desabilita contagem de registros  
 set nocount on  
 update tblConta   
  set Saldo=@Saldo, Senha=@Senha 
  where NumConta = @NumConta
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end
-----------------------------------------------------------------------------------------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------------------


create proc sp_updateFatura(  
   
 @id int,
 @DataVencimento datetime,  
 @Valor money,  
 @Situacao nvarchar(200),  
 @TipoFatura nvarchar(200),  
 @TaxaJuros nchar(20)) as    
   
  
begin  
	--Verifica se registro existe na tabela conta
	if not exists (select * from tblFatura where idFatura = @id)
	begin
		print 'Registro inexistente'
		return -1
	end
 --desabilita contagem de registros  
 set nocount on  
 update tblFatura   
  set DataVencimento=@DataVencimento, Valor=@Valor, Situacao=UPPER(@Situacao), TipoFatura=UPPER(@TipoFatura), TaxaJuros=rtrim(@TaxaJuros)
  where idFatura = @id
 --verifica se ocorreu algum erro  
 if @@ERROR <> 0   
  return -1  
 else  
  return 0  
 --habilita contagem de registros  
 set nocount off  
  
end


