namespace CursoWindowsForm
{
    partial class Frm_DemostracaoKey
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.Txt_Input = new System.Windows.Forms.TextBox();
            this.Txt_Msg = new System.Windows.Forms.TextBox();
            this.Btn_Reset = new System.Windows.Forms.Button();
            this.Lbl_Minusculo = new System.Windows.Forms.Label();
            this.Lbl_Maiusculo = new System.Windows.Forms.Label();
            this.Gb_Resultado = new System.Windows.Forms.GroupBox();
            this.Txt_Maiusculo = new System.Windows.Forms.TextBox();
            this.Txt_Minusculo = new System.Windows.Forms.TextBox();
            this.Btn_Fechar = new System.Windows.Forms.Button();
            this.Lbl_Input = new System.Windows.Forms.Label();
            this.Gb_Resultado.SuspendLayout();
            this.SuspendLayout();
            // 
            // Txt_Input
            // 
            this.Txt_Input.BackColor = System.Drawing.SystemColors.ControlLightLight;
            this.Txt_Input.ForeColor = System.Drawing.SystemColors.WindowText;
            this.Txt_Input.Location = new System.Drawing.Point(28, 34);
            this.Txt_Input.Name = "Txt_Input";
            this.Txt_Input.Size = new System.Drawing.Size(343, 22);
            this.Txt_Input.TabIndex = 0;
            this.Txt_Input.KeyDown += new System.Windows.Forms.KeyEventHandler(this.Txt_Input_KeyDown);
            // 
            // Txt_Msg
            // 
            this.Txt_Msg.BackColor = System.Drawing.SystemColors.Control;
            this.Txt_Msg.ForeColor = System.Drawing.SystemColors.WindowText;
            this.Txt_Msg.Location = new System.Drawing.Point(28, 74);
            this.Txt_Msg.Multiline = true;
            this.Txt_Msg.Name = "Txt_Msg";
            this.Txt_Msg.ReadOnly = true;
            this.Txt_Msg.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.Txt_Msg.Size = new System.Drawing.Size(343, 109);
            this.Txt_Msg.TabIndex = 1;
            // 
            // Btn_Reset
            // 
            this.Btn_Reset.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.Btn_Reset.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.Btn_Reset.Location = new System.Drawing.Point(28, 301);
            this.Btn_Reset.Name = "Btn_Reset";
            this.Btn_Reset.Size = new System.Drawing.Size(113, 31);
            this.Btn_Reset.TabIndex = 2;
            this.Btn_Reset.Text = "Limpar";
            this.Btn_Reset.UseVisualStyleBackColor = false;
            this.Btn_Reset.Click += new System.EventHandler(this.Btn_Reset_Click);
            // 
            // Lbl_Minusculo
            // 
            this.Lbl_Minusculo.AutoSize = true;
            this.Lbl_Minusculo.ForeColor = System.Drawing.SystemColors.WindowText;
            this.Lbl_Minusculo.Location = new System.Drawing.Point(37, 217);
            this.Lbl_Minusculo.Name = "Lbl_Minusculo";
            this.Lbl_Minusculo.Size = new System.Drawing.Size(71, 17);
            this.Lbl_Minusculo.TabIndex = 3;
            this.Lbl_Minusculo.Text = "Minusculo";
            // 
            // Lbl_Maiusculo
            // 
            this.Lbl_Maiusculo.AutoSize = true;
            this.Lbl_Maiusculo.ForeColor = System.Drawing.SystemColors.WindowText;
            this.Lbl_Maiusculo.Location = new System.Drawing.Point(9, 63);
            this.Lbl_Maiusculo.Name = "Lbl_Maiusculo";
            this.Lbl_Maiusculo.Size = new System.Drawing.Size(63, 17);
            this.Lbl_Maiusculo.TabIndex = 4;
            this.Lbl_Maiusculo.Text = "Maisculo";
            // 
            // Gb_Resultado
            // 
            this.Gb_Resultado.Controls.Add(this.Txt_Maiusculo);
            this.Gb_Resultado.Controls.Add(this.Txt_Minusculo);
            this.Gb_Resultado.Controls.Add(this.Lbl_Maiusculo);
            this.Gb_Resultado.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.Gb_Resultado.Location = new System.Drawing.Point(28, 190);
            this.Gb_Resultado.Name = "Gb_Resultado";
            this.Gb_Resultado.Size = new System.Drawing.Size(342, 105);
            this.Gb_Resultado.TabIndex = 5;
            this.Gb_Resultado.TabStop = false;
            this.Gb_Resultado.Text = "Resultado";
            this.Gb_Resultado.Enter += new System.EventHandler(this.groupBox1_Enter);
            // 
            // Txt_Maiusculo
            // 
            this.Txt_Maiusculo.Location = new System.Drawing.Point(109, 60);
            this.Txt_Maiusculo.Name = "Txt_Maiusculo";
            this.Txt_Maiusculo.ReadOnly = true;
            this.Txt_Maiusculo.Size = new System.Drawing.Size(209, 22);
            this.Txt_Maiusculo.TabIndex = 6;
            // 
            // Txt_Minusculo
            // 
            this.Txt_Minusculo.Location = new System.Drawing.Point(109, 27);
            this.Txt_Minusculo.Name = "Txt_Minusculo";
            this.Txt_Minusculo.ReadOnly = true;
            this.Txt_Minusculo.Size = new System.Drawing.Size(209, 22);
            this.Txt_Minusculo.TabIndex = 5;
            // 
            // Btn_Fechar
            // 
            this.Btn_Fechar.BackColor = System.Drawing.SystemColors.ControlDarkDark;
            this.Btn_Fechar.Location = new System.Drawing.Point(258, 301);
            this.Btn_Fechar.Name = "Btn_Fechar";
            this.Btn_Fechar.Size = new System.Drawing.Size(113, 31);
            this.Btn_Fechar.TabIndex = 6;
            this.Btn_Fechar.Text = "Sair";
            this.Btn_Fechar.UseVisualStyleBackColor = false;
            this.Btn_Fechar.Click += new System.EventHandler(this.Btn_Fechar_Click);
            // 
            // Lbl_Input
            // 
            this.Lbl_Input.AutoSize = true;
            this.Lbl_Input.ForeColor = System.Drawing.SystemColors.WindowText;
            this.Lbl_Input.Location = new System.Drawing.Point(28, 11);
            this.Lbl_Input.Name = "Lbl_Input";
            this.Lbl_Input.Size = new System.Drawing.Size(75, 17);
            this.Lbl_Input.TabIndex = 7;
            this.Lbl_Input.Text = "Digite algo";
            // 
            // Frm_DemostracaoKey
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.Control;
            this.ClientSize = new System.Drawing.Size(409, 346);
            this.Controls.Add(this.Lbl_Input);
            this.Controls.Add(this.Btn_Fechar);
            this.Controls.Add(this.Lbl_Minusculo);
            this.Controls.Add(this.Btn_Reset);
            this.Controls.Add(this.Txt_Msg);
            this.Controls.Add(this.Txt_Input);
            this.Controls.Add(this.Gb_Resultado);
            this.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle;
            this.Name = "Frm_DemostracaoKey";
            this.Opacity = 0.95D;
            this.Text = "Demostração Evento Key";
            this.Gb_Resultado.ResumeLayout(false);
            this.Gb_Resultado.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox Txt_Input;
        private System.Windows.Forms.TextBox Txt_Msg;
        private System.Windows.Forms.Button Btn_Reset;
        private System.Windows.Forms.Label Lbl_Minusculo;
        private System.Windows.Forms.Label Lbl_Maiusculo;
        private System.Windows.Forms.GroupBox Gb_Resultado;
        private System.Windows.Forms.Button Btn_Fechar;
        private System.Windows.Forms.TextBox Txt_Maiusculo;
        private System.Windows.Forms.TextBox Txt_Minusculo;
        private System.Windows.Forms.Label Lbl_Input;
    }
}