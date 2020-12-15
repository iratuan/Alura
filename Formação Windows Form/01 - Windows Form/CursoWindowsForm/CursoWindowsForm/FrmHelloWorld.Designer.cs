namespace CursoWindowsForm
{
    partial class Frm_HelloWorld
    {
        /// <summary>
        /// Variável de designer necessária.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpar os recursos que estão sendo usados.
        /// </summary>
        /// <param name="disposing">true se for necessário descartar os recursos gerenciados; caso contrário, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código gerado pelo Windows Form Designer

        /// <summary>
        /// Método necessário para suporte ao Designer - não modifique 
        /// o conteúdo deste método com o editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(Frm_HelloWorld));
            this.Lbl_Titulo = new System.Windows.Forms.Label();
            this.Btn_Sair = new System.Windows.Forms.Button();
            this.Txt_Entrada = new System.Windows.Forms.TextBox();
            this.Btn_MudarTexto = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // Lbl_Titulo
            // 
            resources.ApplyResources(this.Lbl_Titulo, "Lbl_Titulo");
            this.Lbl_Titulo.Name = "Lbl_Titulo";
            // 
            // Btn_Sair
            // 
            resources.ApplyResources(this.Btn_Sair, "Btn_Sair");
            this.Btn_Sair.Name = "Btn_Sair";
            this.Btn_Sair.UseVisualStyleBackColor = true;
            this.Btn_Sair.Click += new System.EventHandler(this.Btn_Sair_Click);
            // 
            // Txt_Entrada
            // 
            resources.ApplyResources(this.Txt_Entrada, "Txt_Entrada");
            this.Txt_Entrada.Name = "Txt_Entrada";
            // 
            // Btn_MudarTexto
            // 
            resources.ApplyResources(this.Btn_MudarTexto, "Btn_MudarTexto");
            this.Btn_MudarTexto.Name = "Btn_MudarTexto";
            this.Btn_MudarTexto.UseVisualStyleBackColor = true;
            this.Btn_MudarTexto.Click += new System.EventHandler(this.button1_Click);
            // 
            // Frm_HelloWorld
            // 
            resources.ApplyResources(this, "$this");
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.Controls.Add(this.Btn_MudarTexto);
            this.Controls.Add(this.Txt_Entrada);
            this.Controls.Add(this.Btn_Sair);
            this.Controls.Add(this.Lbl_Titulo);
            this.Name = "Frm_HelloWorld";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label Lbl_Titulo;
        private System.Windows.Forms.Button Btn_Sair;
        private System.Windows.Forms.TextBox Txt_Entrada;
        private System.Windows.Forms.Button Btn_MudarTexto;
    }
}

